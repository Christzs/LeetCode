package com.leetcode.problem.medium;

/**
 * 152. Maximum Product Subarray
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 */
public class p152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, maxTmp = 1, minTmp = 1;
        for (int num : nums) {
            // 出现负数，下次相乘后，最大值变为最小值，最小值变为最大值
            if (num < 0) {
                int tmp = maxTmp;
                maxTmp = minTmp;
                minTmp = tmp;
            }
            // 由于存在负数，同时维护最大最小值
            maxTmp = Math.max(maxTmp * num, num);
            minTmp = Math.min(minTmp * num, num);
            max = Math.max(max, maxTmp);
        }
        return max;
    }

}
