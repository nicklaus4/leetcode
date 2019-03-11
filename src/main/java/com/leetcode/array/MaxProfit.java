package com.leetcode.array;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author weishibai
 * @date 2019/02/26 11:31 AM
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len == 0) {
            return 0;
        }
        int[] max = new int[len];
        max[len - 1] = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], prices[i]);
        }

        int diff = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            diff = Math.max(diff, max[i] - prices[i]);
        }
        return diff;
    }

    public static void main(String[] args) {
        MaxProfit profit = new MaxProfit();
        System.out.println(profit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
