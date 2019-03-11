package com.leetcode.tree;

import java.util.Date;

/**
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 *
 * @author weishibai
 * @date 2019/02/22 2:52 PM
 */
public class TreeTilt {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //官方题解
//    public int traverse(TreeNode root) {
//        if (root == null)
//            return 0;
//        int left = traverse(root.left);
//        int right = traverse(root.right);
//        tilt += Math.abs(left - right);
//        return left + right + root.val;
//    }

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int total = getAbs(root);
        return total + findTilt(root.left) + findTilt(root.right);
    }

    private int getAbs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.abs(getVal(root.left) - getVal(root.right));
    }

    private int getVal(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return root.val + getVal(root.left) + getVal(root.right);
    }

    public static void main(String[] args) {
//        [1,2,null,3,null,4,null,5]

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        root.left.left.right = null;
        root.left.right = null;
        root.right = null;
//        root.right.left = new TreeNode(5);

        TreeTilt tilt = new TreeTilt();
        System.out.println(tilt.findTilt(root));
    }







}
