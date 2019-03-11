package com.leetcode;

/**
 * search insert
 *
 * @author weishibai
 * @date 2019/02/10 7:39 PM
 *
 * 参考博客:https://www.cnblogs.com/luoxn28/p/5767571.html
 */
public class SearchInsert {

    static int findLastEqualSmaller(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return right;
    }

    private static int bbs(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        if (a[high] <= key) {
            return high + 1;
        } else if (a[low] > key) {
            return low;
        }

        while (low < high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal <= key)
                low = mid + 1;
            else  {
                high = mid;
            }
        }

        if (a[high] == key) {
            return high - 1;
        }
        return high;
    }

    public int searchInsert(int[] nums, int target) {
        int ind = findLastEqualSmaller(nums, target);
        if (nums[ind] == target) {
            return ind;
        }
        return ind + 1;
    }

    public static void main(String[] args) {
        SearchInsert insert = new SearchInsert();
        System.out.println(insert.searchInsert(new int[]{1}, 1));
    }

}
