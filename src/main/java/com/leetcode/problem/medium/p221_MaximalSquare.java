package com.leetcode.problem.medium;


/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 */
public class p221_MaximalSquare {

    private static final char TO_BE_FIND = '1';

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int side = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 矩阵元素为0，则无法计为正方形的一条边
                if (matrix[i][j] != TO_BE_FIND) {
                    dp[i][j] = 0;
                    continue;
                }
                int top = i - 1 < 0 ? 0 : dp[i - 1][j];
                int left = j - 1 < 0 ? 0 : dp[i][j - 1];
                int diag = (i - 1 >= 0) && (j - 1 >= 0) ? dp[i - 1][j - 1] : 0;
                // 动态规划：用dp(i,j) 表示以 (i, j)(i,j) 为右下角，且只包含 1 的正方形的边长最大值
                // 状态转移方程如下
                // dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
                dp[i][j] = Math.min(Math.min(top, left), diag) + 1;
                side = Math.max(side, dp[i][j]);
            }
        }
        return side * side;
    }


    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        p221_MaximalSquare maximalSquare = new p221_MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(matrix));
    }


}
