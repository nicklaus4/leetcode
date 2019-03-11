package com.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 *
 * @author weishibai
 * @date 2019/02/28 2:32 PM
 */
public class MinOperateDistance {

    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }

        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                final char ch1 = word1.charAt(i - 1);
                final char ch2 = word2.charAt(j - 1);
                if (ch1 != ch2) {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1); /* 删除或增加一个 */
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1); /* 替换 */
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        MinOperateDistance distance = new MinOperateDistance();
        System.out.println(distance.minDistance("horse", "ros"));
        System.out.println(distance.minDistance("intention", "execution"));
    }

}
