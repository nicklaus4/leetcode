package com.leetcode;

/**
 * longest palindrome
 *
 * @author weishibai
 * @date 2019/02/22 11:56 AM
 * @leetcode https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if ("".equalsIgnoreCase(s)) {
            return "";
        }

        int length = s.length();
        int start = -1, end = -1;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            start = i;
            end = i;
        }

        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                end = i + 1;
            }
        }

        for (int k = 2; k < length; k ++) {
            for (int i = 0; i < length - k; i ++) {
                if (s.charAt(i) == s.charAt(i + k) && dp[i + 1][i + k - 1]) {
                    dp[i][i + k] = true;
                    start = i;
                    end = i + k;
                }
            }
        }

        if (start >= 0) {
            return s.substring(start, end + 1);
        }
        return s.substring(0, 1);
    }

    public static void main(String[] args) {
        LongestPalindrome drome = new LongestPalindrome();
        System.out.println(drome.longestPalindrome("babad"));
        System.out.println(drome.longestPalindrome("cbbd"));
        System.out.println(drome.longestPalindrome("bdabadd"));
    }


}
