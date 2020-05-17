package com.leetcode.problem.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 210. Course Schedule II
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 */
public class p210_CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[]{};
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int[] input = new int[numCourses];

        // 遍历所有边统计入度
        for (int[] edge : prerequisites) {
            input[edge[0]]++;
        }
        // 入度为零的定点入队
        for (int i = 0; i < numCourses; i++) {
            if (input[i] == 0) {
                queue.offer(i);
            }
        }

        // 宽度优先遍历
        int index = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            res[index++] = tmp;
            for (int[] edge : prerequisites) {
                if (edge[1] == tmp) {
                    input[edge[0]]--;
                    if (input[edge[0]] == 0) {
                        queue.offer(edge[0]);
                    }
                }
            }
        }
        if (index != numCourses) {
            return new int[]{};
        }
        return res;

    }

}
