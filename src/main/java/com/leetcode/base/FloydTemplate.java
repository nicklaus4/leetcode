package com.leetcode.base;

/**
 * floyd template
 *
 * @author weishibai
 * @date 2019/02/27 10:58 PM
 */
public class FloydTemplate {

    //Floyd-Warshall算法不能解决带有“负权回路”（或者叫“负权环”）的图
    //可以再n2 看看有无松弛出现判断是否有negative weight
    public void floyd(int[][] graph, int n) {

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }
}
