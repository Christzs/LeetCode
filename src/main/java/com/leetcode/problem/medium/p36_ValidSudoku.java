package com.leetcode.problem.medium;

import java.util.HashMap;

/**
 * 36. Valid Sudoku
 *
 * Determine if a 9x9 Sudoku board is valid. 
 *
 * Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 */
public class _36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j];
                if (num == '.') {
                    continue;
                }
                int boxIndex = (i / 3) * 3 + j / 3;
                rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                columns[j].put(num, columns[j].getOrDefault(num, 0) + 1);
                boxes[boxIndex].put(num, boxes[boxIndex].getOrDefault(num, 0) + 1);

                if (rows[i].get(num) > 1 || columns[j].get(num) > 1 || boxes[boxIndex].get(num) > 1) {
                    return false;
                }
            }
        }
        return true;


    }
}
