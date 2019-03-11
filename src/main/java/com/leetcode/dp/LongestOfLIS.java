package com.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * 题解:https://blog.csdn.net/xuxuxuqian1/article/details/81071975
 *
 * @author weishibai
 * @date 2019/02/24 6:40 PM
 */
public class LongestOfLIS {


    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] lis = new int[len];
        int[] counter = new int[len];
        lis[0] = 1;
        int max = lis[0];
        counter[0] = 1;

        for (int i = 1; i < len; i ++) {
            lis[i] = 1;
            counter[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    counter[i] = counter[j];
                } else if (nums[j] < nums[i] && lis[j] + 1 == lis[i]) {
                    counter[i] += counter[j];
                }
            }
            max = Math.max(max, lis[i]);
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            if (max == lis[i]) {
                result += counter[i];
            }
        }
        return result;
    }

    private int binarySearch(int[] nums, int len, int target) {
        int st = 0;
        int ed = len;
        while (st <= ed) {
            int mid = (st + ed) >> 1;
            if (nums[mid] >= target) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }

    //nlogn的算法
    public int betterLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] lis = new int[len];
        lis[0] = nums[0];
        int cnt = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > lis[cnt - 1]) {
                lis[cnt ++] = nums[i];
            } else {
                /* 找出第一个比nums[i]大的元素，然后进行替换 */
                int ind = binarySearch(lis, cnt, nums[i]);
                lis[ind] = nums[i];
            }
        }
        return cnt;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] lis = new int[len];
        lis[0] = 1;

        for (int i = 1; i < len; i ++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = -1;
        for (int i = 0; i < len; i++) {
            if (lis[i] > max) {
                max = lis[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestOfLIS lis = new LongestOfLIS();
//        System.out.println(lis.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(lis.betterLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(lis.betterLIS(new int[]{2, 2}));
//        System.out.println(lis.betterLIS(new int[]{4, 10, 4, 3, 8, 9}));
//        System.out.println(lis.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
//        System.out.println(lis.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
//        System.out.println(lis.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
        System.out.println(lis.findNumberOfLIS(new int[]{1}));
//        System.out.println(lis.lengthOfLIS(new int[]{2, 2, 2, 2, 2}));
//        System.out.println(lis.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));


    }


}
