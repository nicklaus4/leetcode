package com.leetcode;

/**
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 *
 * @author weishibai
 * @date 2019/02/22 2:30 PM
 */
public class StringDistance {

    public int minDistance(String word1, String word2) {
        if ("".equalsIgnoreCase(word1) && "".equalsIgnoreCase(word2)) {
            return 0;
        }

        if ("".equalsIgnoreCase(word1)) {
            return word2.length();
        }

        if ("".equalsIgnoreCase(word2)) {
            return word1.length();
        }

        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                dp[i][0] = 1;
            } else {
                if (i > 0) {
                    dp[i][0] = dp[i - 1][0];
                }
            }
        }

        for (int j = 0; j < word2.length(); j++) {
            if (word2.charAt(j) == word1.charAt(0)) {
                dp[0][j] = 1;
            } else {
                if (j > 0) {
                    dp[0][j] = dp[0][j - 1];
                }
            }
        }

        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length() - 1][word2.length() - 1];
    }

    public static void main(String[] args) {
        StringDistance distance = new StringDistance();
        System.out.println(distance.minDistance("sea", "eat"));
    }





}
