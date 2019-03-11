package com.leetcode.array;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * https://blog.csdn.net/jmspan/article/details/51158516
 * 二分查找，证明如果小于等于m的数超过m则重复在1~m
 *
 * @author weishibai
 * @date 2019/02/23 7:56 PM
 */
public class DuplicateNumber {



    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            int cnt = 0;
            for (int num : nums) {
                if (mid >= num) {
                    cnt ++;
                }
            }

            if (cnt > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }



}
