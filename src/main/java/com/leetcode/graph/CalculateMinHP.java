package com.leetcode.graph;

/**
 * https://leetcode-cn.com/problems/dungeon-game/
 *
 * https://www.cnblogs.com/albert-ygy/p/9461056.html
 *
 * @author weishibai
 * @date 2019/02/28 6:38 PM
 */
public class CalculateMinHP {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        /* 从后往前推导 */
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(0, -dungeon[i][j]);
                    continue;
                }

                int downVal = (i == m - 1) ? Integer.MAX_VALUE : dp[i + 1][j];
                int rtVal = (j == n - 1) ? Integer.MAX_VALUE : dp[i][j + 1];
                dp[i][j] = Math.max(0, Math.min(rtVal, downVal) - dungeon[i][j]);
            }
        }
        return dp[0][0] + 1;
    }

    public static void main(String[] args) {
        CalculateMinHP hp = new CalculateMinHP();
        System.out.println(hp.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
    }

}
