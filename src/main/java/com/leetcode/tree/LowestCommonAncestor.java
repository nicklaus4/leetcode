package com.leetcode.tree;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author weishibai
 * @date 2019/02/25 10:58 PM
 */
public class LowestCommonAncestor {

    // 此递归方法比较挫..
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }
        if (root == p) {
            return p;
        }

        if (root == q) {
            return q;
        }

        boolean l = hasNode(root.left, p);
        boolean r = hasNode(root.right, q);
        if ((l && r) || (!l && !r)) {
            return root;
        }

        /* both in left */
        if (l && !r) {
            return lowestCommonAncestor(root.left, p, q);
        }

        /* both in right */
        return lowestCommonAncestor(root.right, p, q);
    }

    public boolean hasNode(TreeNode root, TreeNode node) {
        if (null == root) {
            return false;
        }

        if (root == node) {
            return true;
        }
        return hasNode(root.left, node) || hasNode(root.right, node);
    }

    /* better one */
    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        // LCA 问题，查阅相关资料
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor0(root.left, p, q);
        TreeNode right = lowestCommonAncestor0(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();
//        lca.lowestCommonAncestor()
    }



}
