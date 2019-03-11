package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 *
 * @author weishibai
 * @date 2019/02/28 6:20 PM
 */
public class FindAllDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            } else {
                result.add(Math.abs(nums[i]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllDuplicates duplicates = new FindAllDuplicates();
        System.out.println(duplicates.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
