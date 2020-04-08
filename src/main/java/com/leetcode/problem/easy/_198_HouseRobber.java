package com.leetcode.problem.easy;

import java.util.concurrent.locks.StampedLock;

/**
 * 198. House Robber
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 *
 */
public class _198_HouseRobber {

    public int rob(int[] nums) {
//        int len = nums.length;
//        int[] dp = new int[len];
//        int res = -1;
//        for (int i = 0; i < len; i++) {
//            if (i == 0) {
//                dp[i] = nums[i];
//            }
//            if (i == 1) {
//                dp[i] = Math.max(nums[i], nums[i - 1]);
//            }
//            if (i > 1){
//                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//            }
//            res = Math.max(dp[i], res);
//        }
        int preMax = 0;
        int curMax = 0;
        for (int n : nums) {
            int temp = curMax;
            curMax = Math.max(preMax + n, curMax);
            preMax = temp;
        }
        return curMax;
    }

}
