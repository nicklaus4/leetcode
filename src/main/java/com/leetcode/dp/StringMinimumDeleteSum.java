package com.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/
 *
 * lcs类似
 * https://blog.csdn.net/obrcnh/article/details/78378773
 *
 * @author weishibai
 * @date 2019/02/28 1:08 PM
 */
public class StringMinimumDeleteSum {

    public int minimumDeleteSum(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }

        //lcs 然后分别保存一下lcs对应字符串,然后进行对比运算
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + s1.charAt(i - 1) + s2.charAt(j - 1));
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        StringMinimumDeleteSum deleteSum = new StringMinimumDeleteSum();
//        System.out.println(deleteSum.minimumDeleteSum("sea", "eat"));
//        System.out.println(deleteSum.minimumDeleteSum("delete", "leet"));
        System.out.println(deleteSum.minimumDeleteSum("a", "at"));
    }
}
