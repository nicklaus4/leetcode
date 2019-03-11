package com.leetcode.array;

/**
 * https://leetcode-cn.com/problems/multiply-strings/
 *
 * @author weishibai
 * @date 2019/02/27 4:45 PM
 */
public class BigDataMultiply {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 * len2 + 1];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int lf = num1.charAt(i) - '0';
            int rest = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int rt = num2.charAt(j) - '0';

                int index = len1 + len2 - 2 - i - j;
                int total = result[index] + lf * rt + rest;
                result[index] = (total) % 10;
                rest = (total) / 10;
            }
            result[len1 - 1 - i + len2] += rest;
        }
        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] == 0 && zero) {
                continue;
            }
            zero = false;
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BigDataMultiply multiply = new BigDataMultiply();
        System.out.println(multiply.multiply("123", "456"));
        System.out.println(multiply.multiply("3", "2"));
        System.out.println(multiply.multiply("3", "0"));
    }

}
