package com.leetcode.problem.medium;

/**
 * 59. Spiral Matrix II
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 */
public class _59_SpiralMatrix2 {

    public static int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];

        // 设置螺旋顺序边界
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 0;
        while (top <= bottom && left <= right) {
            // 按照螺旋顺序依次添加
            for (int i = left; i <= right; i++) {
                res[top][i] = ++num;
            }
            for (int i = top + 1; i <= bottom; i++) {
                res[i][right] = ++num;
            }
            if (top < bottom && left < right) {
                for (int i = right - 1; i > left; i--) {
                    res[bottom][i] = ++num;
                }
                for (int i = bottom; i > top; i--) {
                    res[i][left] = ++num;
                }
            }
            // 边界收缩
            top++;
            bottom--;
            left++;
            right--;
        }

        return res;

    }

    public static void main(String[] args) {
        generateMatrix(3);
    }

}
