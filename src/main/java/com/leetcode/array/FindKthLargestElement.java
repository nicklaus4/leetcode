package com.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @author weishibai
 * @date 2019/02/27 11:59 AM
 */
public class FindKthLargestElement {

    /* 小顶堆 */
    public int[] buildMinHeap(int[] arr, int k) {
        int[] copied = Arrays.copyOfRange(arr, 0, k);

        for (int i = father(copied.length - 1); i >= 0; i --) {
            minHeapify(copied, copied.length, i);
        }
        return copied;

    }

    public void minHeapify(int[] arr, int size, int i) {
        int lf = leftChild(i);
        int rt = rightChild(i);

        int min = i;
        if (lf < size && arr[lf] < arr[i]) {
            min = lf;
        }

        if (rt < size && arr[rt] < arr[min]) {
            min = rt;
        }

        if (min != i) {
            swap(arr, i, min);
            minHeapify(arr, size, min);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int father(int i) {
        if (i == 0) {
            return -1;
        }
        return (i - 1) >> 1;
    }

    public int leftChild(int i) {
        return i * 2 + 1;
    }

    public int rightChild(int i) {
        return i * 2 + 2;
    }

    public int findKthLargest(int[] nums, int k) {
        int[] heap = buildMinHeap(nums, k);


        int len = nums.length;
        for (int i = k; i < len; i++) {
            if (nums[i] > heap[0]) {
                heap[0] = nums[i];
                minHeapify(heap, heap.length, 0);
            }
        }
        return heap[0];
    }

    public static void main(String[] args) {
        FindKthLargestElement element = new FindKthLargestElement();
        System.out.println(element.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(element.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }


}
