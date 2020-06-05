package com.leetcode.problem.interview;

/**
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class p29_ClockwisePrintArray {

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[]{};
        }
        int n = matrix[0].length;
        int[] res = new int[m * n];
        if (n == 1) {

        }

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        int i = top, j = left, k = 0;
        while (top <= bottom && left <= right) {

            // 顶部遍历
            while (j <= right && k < m * n) {
                res[k++] = matrix[i][j++];
            }
            j--;
            i++;
            // 右部遍历
            while (i <= bottom && k < m * n) {
                res[k++] = matrix[i++][j];
            }
            j--;
            i--;
            // 底部遍历
            while (j > left && k < m * n) {
                res[k++] = matrix[i][j--];
            }

            // 左部遍历
            while (i > top && k < m * n) {
                res[k++] = matrix[i--][j];
            }
            i++;
            j++;
            top++;
            left++;
            bottom--;
            right--;

        }

        return res;
    }

}
