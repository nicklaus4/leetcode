package com.leetcode.tree;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/
 *
 * https://blog.csdn.net/mebiuw/article/details/52901592 简单dfs
 *
 * @author weishibai
 * @date 2019/02/26 12:48 PM
 */
public class PathSumV3 {



    public int pathSum(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }
        return pathSum0(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    private int pathSum0(TreeNode root, int sum) {
        int result = 0;
        if (null == root) {
            return result;
        }

        /* 节点可以是负数，所以继续向下搜索 */
        if (sum == root.val) {
            result ++;
        }
        result += pathSum0(root.left, sum - root.val);
        result += pathSum0(root.right, sum - root.val);
        return result;
    }

    public static void main(String[] args) {
        PathSumV3 v3 = new PathSumV3();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        System.out.println(v3.pathSum(root, 8));
    }


}
