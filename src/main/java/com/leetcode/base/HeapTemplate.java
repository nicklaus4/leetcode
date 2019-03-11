package com.leetcode.base;

import java.util.Arrays;

/**
 * heap template
 *
 * @author weishibai
 * @date 2019/02/25 3:07 PM
 */
public class HeapTemplate {

    public int[] heapSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }

        int len = arr.length;
        int[] copied = buildMaxHeap(arr, len);
        for (int i = len - 1; i >= 0; i--) {
            swap(copied, 0, i);
            maxHeapify(copied, --len, 0);
        }
        return copied;
    }

    /* 逆序 */
    public int[] heapSortMin(int[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }

        int len = arr.length;
        int[] copied = buildMinHeap(arr, len);
        for (int i = len - 1; i >= 0; i--) {
            swap(copied, 0, i);
            minHeapify(copied, --len, 0);
        }
        return copied;
    }


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


    public int[] buildMaxHeap(int[] arr, int k) {
        int[] copied = Arrays.copyOfRange(arr, 0, k);

        for (int i = father(copied.length - 1); i >= 0; i --) {
            maxHeapify(copied, copied.length, i);
        }
        return copied;
    }

    /* 0 ~ n - 1 */
    /*
     *
     */
    public void maxHeapify(int[] arr, int size, int i) {
        int lf = leftChild(i);
        int rt = rightChild(i);

        int max = i;
        if (lf < size && arr[lf] > arr[i]) {
            max = lf;
        }

        if (rt < size && arr[rt] > arr[max]) {
            max = rt;
        }

        if (max != i) {
            swap(arr, i, max);
            maxHeapify(arr, size, max);
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


    public static void main(String[] args) {
        HeapTemplate template = new HeapTemplate();
//        System.out.println(Arrays.toString(template.buildMaxHeap(new int[]{1, 7, 11, 2, 4, 6}, 6)));
//        System.out.println(Arrays.toString(template.buildMinHeap(new int[]{1, 7, 11, 2, 4, 6}, 6)));

        System.out.println(Arrays.toString(template.heapSort(new int[]{1, 7, 11, 2, 4, 6})));
        System.out.println(Arrays.toString(template.heapSortMin(new int[]{1, 7, 11, 2, 4, 6})));
    }



}
