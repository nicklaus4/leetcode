package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author weishibai
 * @date 2019/02/26 1:40 PM
 */
public class PathSumV2 {

    /* 方法有点挫 */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        List<TreeNode> current = new ArrayList<>();
        current.add(root);
        pathSum0(root, sum, result, current);
        return result;
    }

    private void pathSum0(TreeNode root, int sum, List<List<Integer>> result, List<TreeNode> current) {
        if (null == root) {
            return;
        }

        if (root.val == sum && leaf(root)) {
            result.add(view(current));
            return;
        }

        if (root.left != null) {
            current.add(root.left);
            pathSum0(root.left, sum - root.val, result, current);
            current.remove(root.left);
        }

        if (root.right != null) {
            current.add(root.right);
            pathSum0(root.right, sum - root.val, result, current);
            current.remove(root.right);
        }
    }

    /**
     * 采用中序遍历
     */
    private void pathSum1(TreeNode root, int sum, List<List<Integer>> result, List<TreeNode> current) {
        if (null == root) {
            return;
        }

        current.add(root);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result.add(view(current));
            }
        }
        pathSum1(root.left, sum - root.val, result, current);
        pathSum1(root.right, sum - root.val, result, current);
        current.remove(root);
    }

    private List<Integer> view(List<TreeNode> current) {
        return current.stream().map(node -> node.val).collect(Collectors.toList());
    }

    private boolean leaf(TreeNode root) {
        return null != root && root.left == null && root.right == null;
    }

}
