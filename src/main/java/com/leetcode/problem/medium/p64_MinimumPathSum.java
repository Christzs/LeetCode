package com.leetcode.problem.medium;

/**
 * 64. Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 */
public class p64_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = getPaths(i, j, grid);
            }
        }
        return grid[m - 1][n - 1];
    }

    private int getPaths(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        int top = j - 1 < 0 ? Integer.MAX_VALUE : grid[i][j - 1];
        int left = i - 1 < 0 ? Integer.MAX_VALUE : grid[i - 1][j];
        return grid[i][j] + Math.min(top, left);
    }
}
