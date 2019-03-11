package com.leetcode.array;

/**
 * https://leetcode-cn.com/problems/missing-number/
 *
 * @author weishibai
 * @date 2019/02/23 7:53 PM
 */
public class MissingNumber {



    public int missingNumber(int[] nums) {
        int len = nums.length;
        int supported = (len * (len + 1)) >> 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return supported - sum;
    }

}
