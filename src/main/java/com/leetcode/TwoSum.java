package com.leetcode;

import java.util.Arrays;

/**
 * two sum equals to target num
 *
 * @author weishibai
 * @date 2019/02/10 1:15 PM
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        if (size == 2) {
            return new int[] {0, 1};
        }

        int[] sorted = Arrays.copyOf(nums, size);
        Arrays.sort(sorted);


        int[] mapping = new int[size];
        for (int i = 0; i < size; i++) {
            mapping[i] = -1;
        }
        for (int i = 0; i < size; i++) {
            int index = Arrays.binarySearch(sorted, nums[i]);
            if (mapping[index] != -1) {
                if (nums[mapping[index]] + nums[i] == target) {
                    return new int[]{mapping[index], i};
                }
            }
            mapping[index] = i;
        }

        int[] result = new int[2];
        int i = 0;
        int j = size - 1;
        while (true) {
            if (i >= j) {
                break;
            }

            if (sorted[i] + sorted[j] == target) {
                break;
            }

            if (sorted[i] + sorted[j] > target) {
                j --;
            }

            if (sorted[i] + sorted[j] < target) {
                i ++;
            }
        }
        result[0] = Integer.min(mapping[i], mapping[j]);
        result[1] = Integer.max(mapping[i], mapping[j]);
        return result;
    }

    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        System.out.println(Arrays.toString(sum.twoSum(new int[]{3, 4, -1, 5}, 2)));
        System.out.println(Arrays.toString(sum.twoSum(new int[]{3, 4, -1, 4}, 8)));
        System.out.println(Arrays.toString(sum.twoSum(new int[]{-3, 4, -1, 5}, 3)));
        System.out.println(Arrays.toString(sum.twoSum(new int[]{0, 9, -1, 5}, 8)));
        System.out.println(Arrays.toString(sum.twoSum(new int[]{9, 9, 9, 5, 3}, 8)));
    }



}
