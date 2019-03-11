package com.leetcode.array;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * @author weishibai
 * @date 2019/02/27 1:49 PM
 */
public class SubArraySum {

    private class IntRef {
        int val;

        public IntRef(int val) {
            this.val = val;
        }
    }

    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        IntRef ref = new IntRef(0);
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, k, ref);
        }
        return ref.val;
    }

    private void dfs(int[] nums, int st, int rest, IntRef ref) {
        if (st >= nums.length) {
            return;
        }

        if (nums[st] == rest) {
            ref.val ++;
        }
        dfs(nums, st + 1, rest - nums[st], ref);
    }

    public static void main(String[] args) {
        SubArraySum sum = new SubArraySum();
        System.out.println(sum.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(sum.subarraySum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0));
    }

}
