package com.leetcode.array;

/**
 * https://leetcode-cn.com/problems/largest-number/
 *
 * @author weishibai
 * @date 2019/02/24 10:41 AM
 */
public class LargestNumber {

    private void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = partition(nums, start, end);
            quickSort(nums, start, mid - 1);
            quickSort(nums, mid + 1, end);
        }
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

        String stra = String.valueOf(a);
        String strb = String.valueOf(b);

        long la = Long.valueOf(stra + strb);
        long lb = Long.valueOf(strb + stra);
        return Long.compare(la, lb);
    }

    public String largestNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder result = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i --) {
            if (result.length() <= 0 && nums[i] == 0) {
                continue;
            }
            result.append(nums[i]);
        }

        /* 零头处理 */
        if (result.length() == 0) {
            return "0";
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LargestNumber number = new LargestNumber();
        System.out.println(number.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(number.largestNumber(new int[]{10, 2}));
        System.out.println(number.largestNumber(new int[]{0, 0}));
    }

}
