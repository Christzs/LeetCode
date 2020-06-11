package com.leetcode.problem.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. Daily Temperatures
 *
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 *
 * Example:
 *
 * input: [73, 74, 75, 71, 69, 72, 76, 73]
 * output: [1, 1, 4, 2, 1, 1, 0, 0]
 */
public class p739_DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;

        int[] res = new int[length];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int lastIndex = stack.pop();
                res[lastIndex] = i - lastIndex;
            }
            stack.push(i);
        }

        return res;
    }

}
