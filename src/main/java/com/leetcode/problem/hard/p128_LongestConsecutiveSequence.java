package com.leetcode.problem.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class p128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }
        int res = 0;

        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                int curNume = n;
                int curBreak = 1;
                while (numSet.contains(curNume + 1)) {
                    curBreak++;
                    curNume++;
                }
                res = Math.max(curBreak, res);
            }
        }


        return res;
    }

}
