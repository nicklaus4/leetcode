package com.leetcode.array;

/**
 * find peek element
 *
 * @author weishibai
 * @date 2019/02/25 11:44 AM
 */
public class FindPeekElement {

    public int peekSearch(int[] nums) {
        int st = 0;
        int ed = nums.length - 1;

        while (st < ed) {
            int mid = (st + ed) >> 1;
            if (mid == 0 && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
                return mid;
            }

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] < nums[mid - 1]) {
                ed = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                st = mid + 1;
            }
        }
        return st;
    }

    public int findPeakElement(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        return peekSearch(nums);
    }

    public static void main(String[] args) {
        FindPeekElement element = new FindPeekElement();
        System.out.println(element.peekSearch(new int[]{1, 2, 3, 1}));
        System.out.println(element.peekSearch(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(element.peekSearch(new int[]{1, 2, 3}));
    }



}
