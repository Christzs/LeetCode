package com.leetcode.problem.hard;

/**
 * 45. Jump Game II
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 */
public class _45_JumpGameII {

    public int jump(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int end = 0;
        int res = 0;
        int maxJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 贪心算法, 寻找能够跳的最远的位置
            maxJump = Math.max(maxJump, nums[i] + i);
            if (i == end) {
                end = maxJump;
                res++;
            }
        }
        return res;
    }

}
