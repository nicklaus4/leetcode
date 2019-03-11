package com.leetcode.base;

/**
 * longest common subsequence
 *
 * @author weishibai
 * @date 2019/02/28 1:28 PM
 */
public class LCSTemplate {

    public int lcs(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }


    public static void main(String[] args) {
        LCSTemplate lcsTemplate = new LCSTemplate();
        System.out.println(lcsTemplate.lcs("sea", "eat"));
        System.out.println(lcsTemplate.lcs("delete", "leet"));
    }


}
