package com.leetcode.base;

/**
 * 最短路径算法
 *
 * @author weishibai
 * @date 2019/02/27 10:36 PM
 */
public class DijkstraTemplate {

    int[] dis;

    public void dijkstra(int start, int[][] graph, int n, int m) {
        dis = new int[n];
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        dis[start] = 0;
        visit[start] = true;

        //n - 1 loop
        for (int i = 0; i < n - 1; i++) {

            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (j != start) {
                    dis[j] = graph[start][j];
                    if (min > dis[j]) {
                        min = dis[j];
                        index = j;
                    }
                }
            }
            visit[index] = true;

            /* adjust dis */
            for (int j = 0; j < n; j++) {
                if (!visit[j] && dis[j] > dis[index] + graph[index][j]) {
                    dis[j] = dis[index] + graph[index][j];
                }
            }
        }
    }


}
