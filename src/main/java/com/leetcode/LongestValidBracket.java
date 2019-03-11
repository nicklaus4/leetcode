package com.leetcode;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * 动态规划解法
 * https://blog.csdn.net/weixin_38823568/article/details/80997966
 * 这个方法太巧了，值得玩味
 * @author weishibai
 * @date 2019/02/26 3:01 PM
 */
public class LongestValidBracket {


    public int longestValidParentheses(String s) {
        if ("".equals(s)) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len];
        final char[] chars = s.toCharArray();
        int max = 0;
        for (int i = len - 2; i >= 0; i --) {
            int end = i + 1 + dp[i + 1];
            if (chars[i] == '(' && end <= len - 1 && chars[end] == ')') {
                dp[i] = dp[i + 1] + 2;

                /* 下一个跨度用于解决()()这种case */
                if (end + 1 <= len - 1) {
                    dp[i] += dp[end + 1];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidBracket bracket = new LongestValidBracket();
        System.out.println(bracket.longestValidParentheses(")()())"));
        System.out.println(bracket.longestValidParentheses("(()"));
    }

}
