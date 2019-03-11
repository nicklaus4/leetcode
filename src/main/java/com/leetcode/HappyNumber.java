package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/happy-number/
 *
 * @author weishibai
 * @date 2019/02/24 10:28 AM
 */
public class HappyNumber {

    //    4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4
    private static Set<Integer> forbids = new HashSet<>();

    static {
        forbids.add(4);
        forbids.add(16);
        forbids.add(37);
        forbids.add(58);
        forbids.add(89);
        forbids.add(145);
        forbids.add(42);
        forbids.add(20);
    }

    public boolean isHappy(int n) {

        int current = n;
        while (true) {

            int sum = 0;
            while (current > 0) {
                sum += Math.pow((current % 10), 2);
                current /= 10;
            }

            if (forbids.contains(sum)) {
                return false;
            }

            if (sum == 1) {
                return true;
            }
            current = sum;
        }
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
        System.out.println(happyNumber.isHappy(81));
    }

}
