package com.leetcode.tree;

import static com.leetcode.tree.TreeUtils.inOrderPrint;
import static com.leetcode.tree.TreeUtils.preOrderPrint;

import java.util.Arrays;

/**
 * build tree from pre and in order
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author weishibai
 * @date 2019/02/23 11:48 AM
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == inorder || inorder.length == 0
                || null == preorder || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = indexOf(inorder, preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1)
                , Arrays.copyOfRange(inorder, 0, rootIndex));

        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length)
                , Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
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
        BuildTree tree = new BuildTree();
        TreeNode treeNode = tree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        preOrderPrint(treeNode);
        inOrderPrint(treeNode);
    }

}
