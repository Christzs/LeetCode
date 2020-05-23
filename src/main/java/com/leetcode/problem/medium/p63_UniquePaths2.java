package com.leetcode.problem.medium;

/**
 * 63. Unique Paths II
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 */
public class p63_UniquePaths2 {

    private int[][] paths;

    private int m;

    private int n;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        this.m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        this.n = obstacleGrid[0].length;
        this.paths = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    paths[0][0] = obstacleGrid[i][j] == 1 ? 0 : 1;
                } else {
                    paths[i][j] = getPaths(i, j, obstacleGrid);
                }
            }
        }
        return paths[m - 1][n - 1];
    }

    private int getPaths(int i, int j, int[][] obstacleGrid) {
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        int top = j - 1 < 0 ? 0 : paths[i][j - 1];
        int left = i - 1 < 0 ? 0 : paths[i - 1][j];
        return top + left;
    }
}
