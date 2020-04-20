package com.leetcode.problem.medium;

/**
 * 200. Number of Islands
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 *
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class p200_NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ++res;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

}
