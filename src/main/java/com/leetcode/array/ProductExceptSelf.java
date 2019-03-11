package com.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 *
 * 此类问题，单边想不通的情况下考虑双边处理，换换思路
 *
 * @author weishibai
 * @date 2019/02/26 10:06 AM
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];


        int current = 1;
        result[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            current *= nums[i];
            result[i + 1] = current;
        }

        int len = nums.length;
        current = 1;
        for (int i = len - 1; i > 0; i --) {
            current *= nums[i];
            result[i - 1] *= current;
        }
        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf self = new ProductExceptSelf();
        System.out.println(Arrays.toString(self.productExceptSelf(new int[]{1, 2, 3, 4})));
    }


}
