package com.leetcode.array;

/**
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 *
 * @author weishibai
 * @date 2019/02/25 12:50 PM
 */
public class PeakIndexInMountainArray {

    public int peekSearch(int[] nums) {
        int st = 0;
        int ed = nums.length - 1;

        while (st < ed) {
            int mid = (st + ed) >> 1;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] < nums[mid + 1]) {
                st = mid + 1;
            } else {
                ed = mid;
            }
        }
        return st;
    }

    public int peakIndexInMountainArray(int[] arr) {

        return peekSearch(arr);
    }




}
