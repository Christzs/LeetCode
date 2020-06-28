package com.leetcode.problem.medium;

/**
 * 209. Minimum Size Subarray Sum
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public class p209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return len;
        }
        int res = Integer.MAX_VALUE, start = 0, end = 0, sum = 0;
        while (end < len) {
            sum += nums[end];
            while (sum >= s) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
