package com.leetcode.problem.medium;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing
 * the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 * Example:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 */

public class p300_LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] record = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int recordTmp = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    recordTmp = Math.max(recordTmp, 1 + record[j]);
                }
            }
            record[i] = recordTmp;
            res = Math.max(recordTmp, res);
        }
        return res;
    }

    public static void main(String[] args) {
        p300_LongestIncreasingSubsequence longestIncreasingSubsequence = new p300_LongestIncreasingSubsequence();
        int[] nums = new int[]{0,1,0,3,2,3};
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));
    }

}
