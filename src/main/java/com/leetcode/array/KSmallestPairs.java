package com.leetcode.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 * top k问题可以优先考虑优先队列 or 大顶堆  小顶堆
 *
 * @author weishibai
 * @date 2019/02/25 1:33 PM
 */
public class KSmallestPairs {

    class Pair {
        int n1;
        int n2;
        public Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pairs = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.n1 + o1.n2 - o2.n1 - o2.n2;
            }
        });

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pairs.add(new Pair(nums1[i], nums2[j]));
            }
        }

        int count = 0;
        while (count < k && !pairs.isEmpty()) {
            Pair current = pairs.poll();
            result.add(new int[]{current.n1, current.n2});
            count ++;
        }
        return result;
    }

    public static void main(String[] args) {
        KSmallestPairs pairs = new KSmallestPairs();
//        System.out.println(pairs.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
//        System.out.println(pairs.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
//        System.out.println(pairs.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
        System.out.println(pairs.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
    }

}
