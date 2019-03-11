package com.leetcode.matrix;

/**
 * https://leetcode-cn.com/problems/friend-circles/
 *
 * @author weishibai
 * @date 2019/02/27 5:55 PM
 */
public class FindCircleNum {


    public int findCircleNum(int[][] matrix) {
        int n = matrix[0].length;
        if (n == 1) {
            return 1;
        }

        boolean[] visit = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i, matrix, visit, n);
                count ++;
            }
        }
        return count;
    }

    private void dfs(int x, int[][] matrix, boolean[] visit, int n) {
        for (int i = 0; i < n; i++) {
            if (!visit[i] && matrix[x][i] == 1) {
                visit[i] = true;
                dfs(i, matrix, visit, n);
            }
        }
    }

    //** better way https://blog.csdn.net/mine_song/article/details/70195463


    public static void main(String[] args) {
        FindCircleNum num = new FindCircleNum();
        System.out.println(num.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(num.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));

        //[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
        System.out.println(num.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }


}
