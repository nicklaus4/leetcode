package com.leetcode.base;

import java.util.Arrays;
import java.util.Comparator;

/**
 * kruskal
 *
 * @author weishibai
 * @date 2019/02/28 9:58 AM
 */
public class KruskalTemplate {

    int[] father;
    int[] rank;

    public int find(int x) {
        if (x != father[x]) {
            father[x] = find(father[x]);
        }
        return father[x];
    }

    public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx == fy) {
            return;
        } else if (rank[fx] > rank[fy]) {
            father[fy] = fx;
        } else {
            father[fx] = fy;
            if (rank[fx] == rank[fy]) {
                rank[fy] ++;
            }
        }
    }

    /* 循环方式find */
    public int find0(int x) {
        int root = x;
        while (root != father[root]) {
            root = father[root];
        }

        while (x != root) {
            int t = father[x];
            father[x] = root;
            x = t;
        }
        return root;
    }

    public void build(int n) {
        father = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    private static class Edge {
        private int u;

        private int v;

        private int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

    }



    //////////////////////
    //////////////////////
    public int kruskal(int n, int m, Edge[] edges) {
        Arrays.sort(edges, Comparator.comparingInt(o -> o.w));
        build(n); //并查集

        int total = 0;
        int count = 0;
        for (int i = 0; i < m && count != m - 1; i++) {
            final Edge edge = edges[i];
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                total += edge.w;
                count ++;
            }
        }

        //不连通
        if (count < m - 1) {
            return -1;
        }
        return total;
    }

    public static void main(String[] args) {
        KruskalTemplate kruskalTemplate = new KruskalTemplate();
        Edge[] edges = new Edge[] {new Edge(1, 2, 4)
                , new Edge(1, 2, 4)
                , new Edge(2, 3, 8)
                , new Edge(3, 4, 7)
                , new Edge(4, 5, 9)
                , new Edge(5, 6, 10)
                , new Edge(6, 7, 2)
                , new Edge(7, 8, 1)
                , new Edge(8, 9, 7)
                , new Edge(2, 8, 11)
                , new Edge(3, 9, 2)
                , new Edge(7, 9, 6)
                , new Edge(3, 6, 4)
                , new Edge(4, 6, 14)
                , new Edge(1, 8, 8)
        };

        System.out.println(kruskalTemplate.kruskal(9, 14, edges));
    }


}
