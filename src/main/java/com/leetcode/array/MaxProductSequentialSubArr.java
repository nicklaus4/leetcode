package com.leetcode.array;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 最大乘积子序列，应该算比较经典的一题了
 * 保存当前最大最小乘积，如果当前为负数则进行翻转
 *
 * @author weishibai
 * @date 2019/02/26 10:46 AM
 */
public class MaxProductSequentialSubArr {

    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int len = nums.length;
        int min = 1;
        int max = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < len; i ++) {
            if (nums[i] < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            min = Math.min(min * nums[i], nums[i]);
            max = Math.max(max * nums[i], nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxProductSequentialSubArr arr = new MaxProductSequentialSubArr();
        System.out.println(arr.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(arr.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(arr.maxProduct(new int[]{-2, 3, -4}));
    }


}
