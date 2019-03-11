package com.leetcode.base;

import java.util.Arrays;

/**
 * quick sort template
 *
 * @author weishibai
 * @date 2019/02/25 3:59 PM
 */
public class QuickSortTemplate {

    private void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = partition(nums, start, end);
            quickSort(nums, start, mid - 1);
            quickSort(nums, mid + 1, end);
        }
    }

    private int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        while (start < end) {
            while (compare(nums[start], pivot) <= 0 && start < end) {
                start++;
            }

            nums[end] = nums[start];

            while (compare(nums[end], pivot) >= 0 && start < end) {
                end--;
            }

            nums[start] = nums[end];
        }
        nums[start] = pivot;
        return start;
    }

    private int compare(int a, int b) {
        if (a == b) {
            return 0;
        }
        return a > b ? 1 : (a == b ? 0 : -1);
    }

    public static void main(String[] args) {
        QuickSortTemplate template = new QuickSortTemplate();
        System.out.println(Arrays.toString(template.quickSort(new int[]{1, 7, 11, 2, 4, 6})));
    }

}
