package com.leetcode.problem.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 01 _01_TwoSum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target
 * You may assume that each input would have exactly one solution, and you may not use the same element twice
 *
 * Give nums = [2, 7 , 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9
 *
 * return [0, 1]
 *
 * 解法：利用HashMap将查找时间由`O(n)`降至`O(1)`
 */

class _01_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            if (cache.containsKey(search)) {
                return new int[] {cache.get(search), i};
            }
            cache.put(nums[i], i);
        }
        throw new IllegalArgumentException("Not have solution");
    }

}
