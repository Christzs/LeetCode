package com.leetcode.problem.medium;

import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * 56. Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 */
public class _56_MergeIntervals {

    public int[][] merge(int[][] intervals) {

        int len = intervals.length;

        if (len == 0) {
            return new int[len][];
        }

        List<List<Integer>> res = new ArrayList<>();

        res.add(Arrays.asList(intervals[0][0], intervals[0][1]));

        boolean flag = false;
        for (int[] interval : intervals) {
            int size = res.size();
            List<Integer> merged = Arrays.asList(interval[0], interval[1]);
            List<Integer> removed = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (checkIfMerge(merged, res.get(i))) {
                    merged = merge(merged, res.get(i));
                    removed.add(i);
                    flag = true;
                }
            }
            if (merged.size() != 0 && flag == true) {
                res.add(merged);
            }
            for (int i = removed.size() - 1; i >=0; i--) {
                int index = removed.get(i);
                res.remove(index);
            }
            if (flag == false) {
                res.add(Arrays.asList(interval[0], interval[1]));
            }
            flag = false;
        }

        out.println(res.toString());

        int[][] result = new int[res.size()][2];
        int i = 0;
        for (List<Integer> mergedInterval : res) {
            result[i][0] = mergedInterval.get(0);
            result[i][1] = mergedInterval.get(1);
            i++;
        }
        return result;

    }

    private List<Integer> merge(List<Integer> interval1, List<Integer> interval2) {
        int left = Math.min(interval1.get(0), interval2.get(0));
        int right = Math.max(interval1.get(1), interval2.get(1));
        return Arrays.asList(left, right);
    }

    private boolean checkIfMerge(List<Integer> interval1, List<Integer> interval2) {
        if (interval1.get(0) >= interval2.get(0) && interval1.get(0) <= interval2.get(interval2.size() - 1)) {
            return true;
        }
        if (interval2.get(0) >= interval1.get(0) && interval2.get(0) <= interval1.get(interval1.size() - 1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _56_MergeIntervals mergeIntervals = new _56_MergeIntervals();
        int[][] input = new int[][]{{2, 3}, {4, 5}, {6, 7}, {3, 4}};
//        int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        mergeIntervals.merge(input);
    }

}
