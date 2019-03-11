package com.leetcode.base;

/**
 * dd
 *
 * @author weishibai
 * @date 2019/02/27 10:11 PM
 */
public class GraphRelevant {

    int[] u, v, w;
    int[] head, next; //

    /**
     *
     * @param u
     * @param v
     * @param w
     * @param n  n个顶点
     * @param m  m条边
     */
    private void buildEdge(int[] u, int[] v, int[] w, int n, int m) {
        head = new int[n + 1];
        next = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            head[i] = -1;
        }

        /* m个边 */
        for (int i = 1; i <= m; i++) {
            int st = u[i - 1];
            next[i] = head[st];
            head[st] = i;
        }
    }

    public static void main(String[] args) {
        GraphRelevant relevant = new GraphRelevant();
        int[] u = new int[] {1, 4, 1, 2, 1};
        int[] v = new int[] {4, 3, 2, 4, 3};
        int[] w = new int[] {1, 1, 1, 1, 1};
        relevant.buildEdge(u, v, w, 4, 5);
    }
}
