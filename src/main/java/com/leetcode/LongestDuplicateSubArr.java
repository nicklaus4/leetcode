package com.leetcode;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 *
 * @author weishibai
 * @date 2019/02/22 1:38 PM
 */
public class LongestDuplicateSubArr {


    public int findLength(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return 0;
        }

        int[][] dp = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[0]) {
                dp[i][0] = 1;
            }
        }

        for (int j = 0; j < b.length; j++) {
            if (a[0] == b[j]) {
                dp[0][j] = 1;
            }
        }

        int res = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                if (a[i] == b[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestDuplicateSubArr arr = new LongestDuplicateSubArr();
        System.out.println(arr.findLength(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1}));
    }

}
