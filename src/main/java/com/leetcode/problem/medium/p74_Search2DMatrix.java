package com.leetcode.problem.medium;

/**
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 *
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 */
public class p74_Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }

        int left = 0, right = m - 1, mid = 0;
        // 搜索从哪一行展开二分搜索
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid + 1 < m) {
                if (matrix[mid][0] <= target && matrix[mid + 1][0] > target) {
                    break;
                }
                if (matrix[mid][0] <= target && matrix[mid + 1][0] <= target) {
                    left = mid + 1;
                }
                if (matrix[mid][0] > target) {
                    right = mid - 1;
                }

            } else {
                break;
            }
        }

        // 二分搜索
        int row = mid;
        left = 0;
        right = n - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}
