package com.leetcode.array;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author weishibai
 * @date 2019/02/26 11:13 AM
 */
public class MaxSumSubArr {

    public int maxSubArray(int[] nums) {
        int len = nums.length;

        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSumSubArr arr = new MaxSumSubArr();
//        System.out.println(arr.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(arr.maxSubArray(new int[]{-1, -2}));
        System.out.println(arr.maxSubArray(new int[]{-1}));
    }

}
