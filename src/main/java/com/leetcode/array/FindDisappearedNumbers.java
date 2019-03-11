package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * 方法比较巧妙 学习了
 * @author weishibai
 * @date 2019/02/28 4:41 PM
 */
public class FindDisappearedNumbers {


    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers numbers = new FindDisappearedNumbers();
        System.out.println(numbers.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }


}
