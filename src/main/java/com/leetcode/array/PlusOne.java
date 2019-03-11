package com.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/plus-one/
 *
 * @author weishibai
 * @date 2019/02/27 5:26 PM
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int rest = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int total;
            if (i == digits.length - 1) {
                total = digits[i] + rest + 1;
            } else {
                total = digits[i] + rest;
            }
            digits[i] = total % 10;
            rest = total / 10;
        }
        if (rest == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = rest;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        PlusOne one = new PlusOne();
        System.out.println(Arrays.toString(one.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(one.plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(one.plusOne(new int[]{9, 9})));
    }


}
