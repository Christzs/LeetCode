package com.leetcode.problem.medium;

/**
 * 62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 */
public class p62_UniquePaths {

    private int[][] paths;

    public int uniquePaths(int m, int n) {
        this.paths = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    paths[0][0] = 1;
                } else {
                    paths[i][j] = getPaths(i, j, m, n);
                }
            }
        }
        return paths[m - 1][n - 1];
    }

    private int getPaths(int i, int j, int m, int n) {
        int top = j - 1 < 0 ? 0 : paths[i][j - 1];
        int left = i - 1 < 0 ? 0 : paths[i - 1][j];
        return top + left;
    }

    public static void main(String[] args) {
        p62_UniquePaths uniquePaths = new p62_UniquePaths();
        System.out.println(uniquePaths.uniquePaths(7, 3));
    }

}
