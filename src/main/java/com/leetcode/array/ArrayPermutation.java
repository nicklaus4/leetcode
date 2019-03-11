package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * https://leetcode-cn.com/problems/permutations/
 *
 * https://www.cnblogs.com/zhouthanos/p/3807495.html 递归方式解决
 *
 * @author weishibai
 * @date 2019/02/25 5:55 PM
 */
public class ArrayPermutation {


    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        List<List<Integer>> permute = new ArrayList<>();
        permute0(nums, 0, permute);
        return permute;
    }

    private List<Integer> toList(int[] nums) {
        int[] result = Arrays.copyOf(nums, nums.length);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            list.add(result[i]);
        }
        return list;
    }

    private void permute0(int[] nums, int start, List<List<Integer>> permute) {
        int len = nums.length;
        if (len == start) {
            permute.add(toList(nums));
            return;
        }

        for (int i = start; i < len; i ++) {
            if (isUnique(nums, start, i)) {
                swap(nums, start, i);
                permute0(nums, start + 1, permute);
                swap(nums, start, i);
            }
        }
    }

    /* i 到被交换的数之前不能有跟被交换数重复的数字，否则操作效果是一样的会有重复出现 */
    private boolean isUnique(int[] arr, int st, int ed) {
        for (int i = st; i < ed; i++) {
            if (arr[i] == arr[ed]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        ArrayPermutation permutation = new ArrayPermutation();
        System.out.println(permutation.permute(new int[]{1, 2, 3}));
    }





}
