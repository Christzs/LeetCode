package com.leetcode.problem.interview;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 面试题13. 机器人的运动范围
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 */
public class _13_RangeMotionOfRobot {

    public int movingCount(int m, int n, int k) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{0, 0});
        int count = 0;
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            count++;
            // 向右搜索
            // 满足index不超出边界、数位和小于k且未访问过
            if (poll[0] + 1 < m
                    && sumOfDigit(poll[0] + 1) + sumOfDigit(poll[1]) <= k
                    && !visited[poll[0] + 1][poll[1]]) {
                // 加入搜索队列
                queue.add(new int[]{poll[0] + 1, poll[1]});
                // 置为已访问
                visited[poll[0] + 1][poll[1]] = true;
            }
            // 向上搜索
            if (poll[1] + 1 < n
                    && sumOfDigit(poll[0]) + sumOfDigit(poll[1] + 1) <= k
                    && !visited[poll[0]][poll[1] + 1]) {
                queue.add(new int[]{poll[0], poll[1] + 1});
                visited[poll[0]][poll[1] + 1] = true;
            }
        }
        return count;
    }

    private int sumOfDigit(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

}
