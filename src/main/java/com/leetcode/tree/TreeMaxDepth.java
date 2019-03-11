package com.leetcode.tree;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author weishibai
 * @date 2019/02/23 12:55 PM
 */
public class TreeMaxDepth {

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (null != root.left && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }

        if (null != root.left) {
            return minDepth(root.left) + 1;
        }

        if (root.right != null) {
            return minDepth(root.right) + 1;
        }
        return 1;
    }

    public static void main(String[] args) {
        TreeMaxDepth depth = new TreeMaxDepth();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        System.out.println(depth.minDepth(node));
    }
}
