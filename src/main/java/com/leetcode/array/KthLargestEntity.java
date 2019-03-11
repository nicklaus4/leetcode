package com.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 *
 * @author weishibai
 * @date 2019/02/27 1:10 PM
 */
public class KthLargestEntity {

    static class KthLargest {

        private int[] heap;

        private int[] origin;

        private boolean init;

        private int kth;

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

        public KthLargest(int k, int[] nums) {
            if (k <= nums.length) {
                this.heap = buildMinHeap(nums, k);
                int len = nums.length;
                for (int i = k; i < len; i++) {
                    if (nums[i] > heap[0]) {
                        heap[0] = nums[i];
                        minHeapify(heap, heap.length, 0);
                    }
                }
                init = true;
            } else {
                origin = nums;
                kth = k;
            }
        }

        public int add(int val) {
            if (init) {
                if (val > heap[0]) {
                    heap[0] = val;
                    minHeapify(heap, heap.length, 0);
                    return heap[0];
                } else {
                    return heap[0];
                }
            } else {
                int[] copied = Arrays.copyOf(origin, origin.length + 1);
                copied[origin.length] = val;
                this.heap = buildMinHeap(copied, kth);
                int len = copied.length;
                for (int i = kth; i < len; i++) {
                    if (copied[i] > heap[0]) {
                        heap[0] = copied[i];
                        minHeapify(heap, heap.length, 0);
                    }
                }
                init = true;
                return heap[0];
            }
        }
    }

    public static void main(String[] args) {
//        KthLargest kthLargest = new KthLargest(3, new int[] {4,5,8,2});
//        System.out.println(kthLargest.add(3));
//        System.out.println(kthLargest.add(5));
//        System.out.println(kthLargest.add(10));
//        System.out.println(kthLargest.add(9));
//        System.out.println(kthLargest.add(4));

        KthLargest kthLargest = new KthLargest(1, new int[]{});
        System.out.println(kthLargest.add(-3));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(0));
        System.out.println(kthLargest.add(4));
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

}
