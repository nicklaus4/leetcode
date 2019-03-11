package com.leetcode.tree;

import static com.leetcode.tree.TreeUtils.inOrderPrint;
import static com.leetcode.tree.TreeUtils.postOrderPrint;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author weishibai
 * @date 2019/02/23 12:37 PM
 */
public class InAndPostBuildTree {


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (null == inorder || inorder.length == 0
                || null == postorder || postorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int rootIndex = indexOf(inorder, postorder[postorder.length - 1]);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootIndex)
                , Arrays.copyOfRange(postorder, 0, rootIndex));

        root.right = buildTree(Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length)
                , Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1));
        return root;
    }

    private int indexOf(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        InAndPostBuildTree tree = new InAndPostBuildTree();
        TreeNode treeNode = tree.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        inOrderPrint(treeNode);
        postOrderPrint(treeNode);
    }


}
