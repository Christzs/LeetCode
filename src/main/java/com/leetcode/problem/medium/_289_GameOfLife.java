package com.leetcode.problem.medium;

/**
 * 289. Game of Life
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 *
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * Write a function to compute the next state (after one update) of the board given its current state. 
 *
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously
 *
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 * 解法: 赋予变化后的细胞额外的状态，可以省去额外创建的判断数组
 *
 */
public class _289_GameOfLife {

    private int m;

    private int n;

    private int[][] board;

    public void gameOfLife(int[][] board) {
        this.board = board;
        m = board.length;
        if (m != 0) {
            n = board[0].length;
            boolean[][] survivor = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int cnt = count(i, j);
                    survivor[i][j] = isAlive(board[i][j], cnt);
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (survivor[i][j]) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    private int count(int i, int j) {
        int count = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            if (x >=0 && x < m) {
                for (int y = j - 1; y <= j + 1; y++) {
                    if (y >=0 && y < n) {
                        if (x == i && y == j) {
                            continue;
                        }
                        count = board[x][y] == 1 ? count + 1 : count;
                    }
                }
            }
        }
        return count;
    }

    private boolean isAlive(int cell, int count) {
        if (count < 2 || count > 3) {
            return false;
        }
        if (count == 3) {
            return true;
        }
        return cell != 0;
    }

}
