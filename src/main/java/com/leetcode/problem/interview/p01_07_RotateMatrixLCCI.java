package com.leetcode.problem.interview;

/**
 * 面试题 01.07. Rotate Matrix LCCI
 *
 * Given an image represented by an N x N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
 *
 * input:
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ]
 *
 * output:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 0,0 0,1 0,2
 * 1,0 1,1 1,2
 * 2,0 2,1 2,2
 */
public class p01_07_RotateMatrixLCCI {

    public void rotate(int[][] matrix) {
        int N = matrix.length;
        if (N != 0) {
            // 垂直翻转
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N / 2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][N - j - 1];
                    matrix[i][N - j - 1] = tmp;
                }
            }
            // 对角线翻转
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - i - 1; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[N - j - 1][N - i - 1];
                    matrix[N - j - 1][N - i - 1] = tmp;
                }
            }
        }
    }

}
