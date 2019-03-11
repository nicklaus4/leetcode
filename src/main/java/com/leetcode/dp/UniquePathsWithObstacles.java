package com.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 63. 不同路径 II
 *
 * @author weishibai
 * @date 2019/02/28 4:03 PM
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }

                if (i == 0 && j == 0) {
                    nums[i][j] = 1;
                    continue;
                }

                if (i > 0 && j > 0) {
                    nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
                } else if (i == 0) {
                    nums[i][j] = nums[i][j - 1];
                } else {
                    nums[i][j] = nums[i - 1][j];
                }
            }
        }
        return nums[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles obstacles = new UniquePathsWithObstacles();
        System.out.println(obstacles.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(obstacles.uniquePathsWithObstacles(new int[][]{{1, 0}}));
        System.out.println(obstacles.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }
}
