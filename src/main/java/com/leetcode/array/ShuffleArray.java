package com.leetcode.array;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode-cn.com/problems/shuffle-an-array/
 *
 * @author weishibai
 * @date 2019/02/25 5:42 PM
 */
public class ShuffleArray {

    static class Solution {

        private int[] origin;

        public Solution(int[] nums) {
            this.origin = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return origin;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] copied = Arrays.copyOf(origin, origin.length);
            Random rand = new Random();
            for (int i = copied.length - 1; i >= 0; i--) {
                int ind = rand.nextInt(i + 1);
                swap(copied, ind, i);
            }
            return copied;
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));

    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

}
