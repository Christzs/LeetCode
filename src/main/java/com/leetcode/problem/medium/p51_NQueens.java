package com.leetcode.problem.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 */
public class p51_NQueens {

    /**
     * 存放结果，下标表示行，数值表示列
     */
    private int[] result;

    private int len;

    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.len = n;
        this.res = new ArrayList<>();
        result = new int[len];
        calQueen(0);
        return res;
    }

    private void calQueen(int row) {
        if (row == len) {
            // 满足结果，添加至res
            addRes();
            return;
        }
        for (int column = 0; column < len; column++) {
            if (isOk(row, column)) {
                // 保存本次结果
                result[row] = column;
                // 计算下一行
                calQueen(row + 1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        int leftUp = column - 1, rightUp = column + 1;
        // 逐行往上考察每一行
        for (int i = row - 1; i >= 0; i--) {
            // 向上考察
            if (result[i] == column) {
                return false;
            }
            // 向左上考察
            if (leftUp >= 0) {
                if (result[i] == leftUp) {
                    return false;
                }
            }
            // 向右上考察
            if (rightUp < len) {
                if (result[i] == rightUp) {
                    return false;
                }
            }
            --leftUp;
            ++rightUp;
        }
        return true;
    }


    private void addRes() {
        List<String> tmp = new ArrayList<>();
        for (int row = 0; row < len; row++) {
            StringBuilder builder = new StringBuilder();
            for (int column = 0; column < len; column++) {
                if (result[row] == column) {
                    builder.append("Q");
                } else {
                    builder.append(".");
                }
            }
            tmp.add(builder.toString());
        }
        res.add(tmp);
    }

}
