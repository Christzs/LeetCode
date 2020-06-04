package com.leetcode.problem.medium;

/**
 * 238. Product of Array Except Self
 * Given an array nums of n integers where n > 1
 * , return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 */
public class p238_ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;

        int[] res = new int[size];
        res[0] = 1;

        for (int i = 1; i < size; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int rightValue = 1;
        for (int i = 1; i < size; i++) {
            rightValue = rightValue * nums[size - i];
            res[size - i - 1] = res[size - i - 1] * rightValue;
        }

        return res;

    }

}
