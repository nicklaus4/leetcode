package com.leetcode.matrix;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * https://www.cnblogs.com/grandyang/p/5727892.html
 *
 * @author weishibai
 * @date 2019/02/25 12:59 PM
 */
public class KthSmallestOfMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        if (k == 1) {
            return matrix[0][0];
        }
        int len = matrix[0].length;

        if (k == len * len) {
            return matrix[len - 1][len - 1];
        }

        /* 二分查找法 */
        int st = matrix[0][0];
        int ed = matrix[len - 1][len - 1];

        while (st < ed) {
            int mid = (st + ed) >> 1;
            int cnt = 0;
            for (int i = 0; i < len; i ++) {
                /* 查找每一行比mid小的个数 */
                int num = binarySearch(matrix[i], mid);
                if (num >= len) {
                    cnt += len;
                } else {
                    cnt += num;
                }
            }

            if (cnt < k) {
                st = mid + 1;
            } else {
                ed = mid;
            }
        }
        return st;
    }

    private int binarySearch(int[] arr, int target) {
        int st = 0;
        int ed = arr.length - 1;
        while (st <= ed) {
            int mid = (st + ed) >> 1;
            if (arr[mid] > target) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }

    public static void main(String[] args) {
        KthSmallestOfMatrix matrix = new KthSmallestOfMatrix();
        System.out.println(matrix.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }





}
