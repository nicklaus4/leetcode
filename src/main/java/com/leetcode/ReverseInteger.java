package com.leetcode;

/**
 * reverse integer
 *
 * @author weishibai
 * @date 2019/02/10 2:30 PM
 */
public class ReverseInteger {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger integer = new ReverseInteger();
        System.out.println(integer.reverse(-123));
        System.out.println(integer.reverse(-1233333339));
        System.out.println(integer.reverse(1533333339));
        System.out.println(integer.reverse(150));
    }


}
