package com.leetcode.array;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * https://www.cnblogs.com/ariel-dreamland/p/9166119.html 类似于贪心算法
 *
 * @author weishibai
 * @date 2019/02/26 11:43 AM
 */
public class MaxProfileV2 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int min = 0;
        int max = 0;
        int st = 0;
        int total = 0;
        while (st < prices.length - 1) {
            if (prices[st] > prices[st + 1]) {
                st ++;
                continue;
            }

            min = st;
            max = st + 1;
            while (max < prices.length - 1) {
                if (prices[max] <= prices[max + 1]) {
                    max ++;
                    continue;
                }
                break;
            }
            total += (prices[max] - prices[min]);
            st = max + 1;
        }

        return total;
    }

    public int maxPro(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                count += (prices[i + 1] - prices[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxProfileV2 v2 = new MaxProfileV2();
        System.out.println(v2.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(v2.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(v2.maxPro(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(v2.maxPro(new int[]{1, 2, 3, 4, 5}));
    }

}
