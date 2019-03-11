package com.leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 *
 * @author weishibai
 * @date 2019/02/28 12:34 PM
 */
public class AllPathsSourceToTarget {


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph.length == 0) {
            return Collections.emptyList();
        }

        int n = graph.length;
        List<List<Integer>> result = new ArrayList<>();

        if (1 == n) {
            result.add(Collections.singletonList(0));
            return result;
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, graph, list, result);
        return result;
    }

    public void dfs(int x, int[][] graph, List<Integer> list, List<List<Integer>> result) {
        if (x == graph.length - 1) {
            result.add(copyOf(list));
            return;
        }

        int[] arr = graph[x];
        for (int i = 0; i < arr.length; i++) {
            if (x != arr[i] && !list.contains(arr[i])) {
                list.add(arr[i]);
                dfs(arr[i], graph, list, result);
                list.remove(new Integer(arr[i]));
            }
        }
    }

    private List<Integer> copyOf(List<Integer> list) {
        List<Integer> copied = new ArrayList<>();
        copied.addAll(list);
        return copied;
    }

    public static void main(String[] args) {
        AllPathsSourceToTarget path = new AllPathsSourceToTarget();
//        System.out.println(path.allPathsSourceTarget(new int[][]{{1, 1, 1, 0}, {0, 1, 0, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}}));
        System.out.println(path.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }

}
