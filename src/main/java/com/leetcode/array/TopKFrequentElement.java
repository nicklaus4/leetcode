package com.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author weishibai
 * @date 2019/02/27 11:21 AM
 */
public class TopKFrequentElement {

    private class Pair {
        private int element;

        private int count;

        public Pair(int element, int count) {
            this.element = element;
            this.count = count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return Collections.emptyList();
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.computeIfPresent(num, (x, y) -> y + 1);
            } else {
                countMap.putIfAbsent(num, 1);
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            queue.add(new Pair(entry.getKey(), entry.getValue()));

            if (queue.size() > k) {
                queue.remove();
            }
        }

        List<Integer> result = new ArrayList<>();
        queue.forEach(pair -> result.add(pair.element));
        return reverseList(result);
    }

    private List<Integer> reverseList(List<Integer> origin) {
        List<Integer> result = new ArrayList<>();
        int len = origin.size();
        for (int i = len - 1; i >= 0; i--) {
            result.add(origin.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElement element = new TopKFrequentElement();
        System.out.println(element.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        System.out.println(element.topKFrequent(new int[]{1}, 1));
    }




}
