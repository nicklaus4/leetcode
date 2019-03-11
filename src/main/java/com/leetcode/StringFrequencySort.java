package com.leetcode;

/**
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 *
 * 注意字符串范围是不是ascii
 * count数组也可以考虑使用map来代替，换汤不换药
 * @author weishibai
 * @date 2019/02/27 10:49 AM
 */
public class StringFrequencySort {

    private void quickSort(char[] nums, int[] count, int start, int end) {
        if (start < end) {
            int mid = partition(nums, count, start, end);
            quickSort(nums, count, start, mid - 1);
            quickSort(nums, count, mid + 1, end);
        }
    }

    private int partition(char[] nums, int count[], int start, int end) {
        char pivot = nums[end];
        while (start < end) {
            while (compare(count, nums, start, pivot) <= 0 && start < end) {
                start++;
            }
            nums[end] = nums[start];

            while (compare(count, nums, end, pivot) >= 0 && start < end) {
                end--;
            }
            nums[start] = nums[end];
        }
        nums[start] = pivot;
        return start;
    }

    public String frequencySort(String s) {
        if ("".equals(s)) {
            return s;
        }

        int[] count = new int[200];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)] ++;
        }

        char[] chars = s.toCharArray();
        quickSort(chars, count, 0, s.length() - 1);
        return toString(chars);
    }

    private String toString(char[] chars) {
        if (chars.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    private int compare(int[] count, char[] nums, int i, char pivot) {
        final int i1 = count[nums[i]];
        final int j1 = count[pivot];

        if (i1 == j1) {
            return Character.compare(nums[i], pivot);
        }
        return i1 > j1 ? 1 : (i1 == j1 ? 0 : -1);
    }

    public static void main(String[] args) {
        StringFrequencySort sort = new StringFrequencySort();
        System.out.println(sort.frequencySort("tree"));
        System.out.println(sort.frequencySort("cccaaa"));
        System.out.println(sort.frequencySort("adiadcmmmcz"));
        System.out.println(sort.frequencySort("Aabb"));
        System.out.println(sort.frequencySort("2a554442f544asfasssffffasss"));
        System.out.println(sort.frequencySort("his s he a ha he  ha ae"));
    }

}
