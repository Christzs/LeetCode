package com.leetcode.problem.easy;

/**
 * 136. Single Number
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 */
public class p136_SingleNumber {

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 利用异或的性质
            res = res ^ nums[i];
        }
        return res;
    }

}
