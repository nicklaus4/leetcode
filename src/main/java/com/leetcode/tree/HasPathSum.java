package com.leetcode.tree;

/**
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author weishibai
 * @date 2019/02/26 12:43 PM
 */
public class HasPathSum {



    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }

        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


}
