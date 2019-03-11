package com.leetcode.array;

import java.util.Arrays;

/**
 * next permutation
 * https://blog.csdn.net/nichchen/article/details/78258652
 *
 * @author weishibai
 * @date 2019/02/25 7:13 PM
 */
public class NextPermutation {

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //1　　2　　7　　4　　3　　1
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 2; i >= 0; i --) {
            if (nums[i + 1] > nums[i]) {
                int ind = -1;
                for (int j = len - 1; j >= i; j--) {
                    if (nums[j] > nums[i]) {
                        ind = j;
                        break;
                    }
                }
                swap(nums, i, ind);
                /* 对i后面的数字进行排序 */
                int cnt = (len - 1 - i) >> 1;
                int st = i + 1, ed = len - 1;
                while (cnt > 0) {
                    swap(nums, st ++, ed --);
                    cnt --;
                }
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        NextPermutation permutation = new NextPermutation();
        int[] arr = {3, 2, 1};
        permutation.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

}
