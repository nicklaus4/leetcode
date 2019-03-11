package com.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/single-number/
 *
 * @author weishibai
 * @date 2019/02/23 1:19 PM
 */
public class SingleShowNumber {

    /**
     * 其他只出现两次
     *
     * @param nums
     * @return
     */
    private int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        return x;
    }

    /**
     * 其他只出现三次
     *
     * @param nums
     * @return
     */
    public int singleNumber0(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                int bit = (num >> i) & 1;
                cnt += bit;
            }

            if (cnt % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }

    /**
     * 只有两个出现一次，其他均出现两次
     * 解题思路，先获取x ^ y，然后根据一个为1的bit位进行区分数据，然后分别异或即可
     */
    public int[] singleNumber1(int[] nums) {
        int xy = 0;
        for (int num : nums) {
            xy ^= num;
        }

        int ind = (xy & -xy);
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & ind) > 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        SingleShowNumber number = new SingleShowNumber();
//        System.out.println(number.singleNumber(new int[]{4, 1, 2, 1, 2}));
//        System.out.println(number.singleNumber(new int[]{2, 2, 1}));
        System.out.println(number.singleNumber0(new int[]{2, 2, 3, 2}));
        System.out.println(number.singleNumber0(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println(Arrays.toString(number.singleNumber1(new int[]{1, 2, 1, 3, 2, 5})));
    }


}
