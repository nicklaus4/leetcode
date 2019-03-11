package com.leetcode.tree;

/**
 * tree utils
 *
 * @author weishibai
 * @date 2019/02/23 12:30 PM
 */
public class TreeUtils {
    public static void preOrderPrint(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }

        System.out.print(treeNode.val + " ");
        preOrderPrint(treeNode.left);
        preOrderPrint(treeNode.right);
    }

    public static void inOrderPrint(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        inOrderPrint(treeNode.left);
        System.out.print(treeNode.val + " ");
        inOrderPrint(treeNode.right);
    }

    public static void postOrderPrint(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        postOrderPrint(treeNode.left);
        postOrderPrint(treeNode.right);
        System.out.print(treeNode.val + " ");
    }
}
