package com.leetcode.problem.medium;

/**
 * 48. Rotate Image
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 */
public class p48_RotateImage {

    public void rotate(int[][] matrix) {

        int len = matrix.length;

        // 转置矩阵
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        // 镜像
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len /2; j++) {
                int tmp = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

    }

}
