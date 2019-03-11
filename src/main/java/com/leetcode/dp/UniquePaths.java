package com.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 62. 不同路径
 *
 * @author weishibai
 * @date 2019/02/28 3:03 PM
 */
public class UniquePaths {

    private static int[][] coord = new int[][]{{0, 1}, {1, 0}};

    public int uniquePaths(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        return dfs(0, 0, visited);
    }

    /* 递归会超时 */
    private int dfs(int x, int y, boolean[][] visited) {
        if (x >= visited.length || x < 0 || y >= visited[0].length || y < 0) {
            return 0;
        }

        if (x == visited.length - 1 && y == visited[0].length - 1) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < 2; i++) {
            int xx = x + coord[i][0];
            int yy = y + coord[i][1];

            if (xx < visited.length && yy < visited[0].length && !visited[xx][yy]) {
                visited[xx][yy] = true;
                count += dfs(xx, yy, visited);
                visited[xx][yy] = false;
            }
        }
        return count;
    }

    public int uniquePaths0(int m, int n) {
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    nums[i][j] = 1;
                else
                    nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }
        return nums[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths path = new UniquePaths();
        System.out.println(path.uniquePaths(3, 2));
        System.out.println(path.uniquePaths(7, 3));
    }



}
