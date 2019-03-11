package com.leetcode.tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 1.先遍历右子树并求和
 * 2.赋值
 * 3.遍历左子树
 * @author weishibai
 * @date 2019/02/23 10:56 AM
 */
public class ConvertBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class IntRef {
        int val;
        IntRef(int val) {
            this.val = val;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        if (null == root) {
            return null;
        }
        dfs(root, new IntRef(0));
        return root;
    }

    private void dfs(TreeNode root, IntRef total) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            dfs(root.right, total);
        }
        root.val += total.val;
        total.val = root.val;
        dfs(root.left, total);
    }

    public static void main(String[] args) {
        ConvertBST bst = new ConvertBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        root = bst.convertBST(root);
    }
}
