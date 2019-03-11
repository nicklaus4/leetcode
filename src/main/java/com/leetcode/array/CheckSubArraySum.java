package com.leetcode.array;

/**
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 *
 * @author weishibai
 * @date 2019/02/27 4:04 PM
 */
public class CheckSubArraySum {



    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (dfs(nums, i, 0, 1, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int[] nums, int st, int prev, int count, int k) {
        if (nums.length <= st) {
            return false;
        }

        if ((k != 0 && (nums[st] + prev) % k == 0) && count >= 2
                || (k == 0 && count >= 2 && nums[st] + prev == 0)) {
            return true;
        }
        return dfs(nums, st + 1, nums[st] + prev, count + 1, k);
    }

    public static void main(String[] args) {
        CheckSubArraySum sum = new CheckSubArraySum();
        System.out.println(sum.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(sum.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(sum.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 0));
        System.out.println(sum.checkSubarraySum(new int[]{0}, 0));
        System.out.println(sum.checkSubarraySum(new int[]{0, 0}, 0));
    }


}
