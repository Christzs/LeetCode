package com.leetcode.problem.medium;

import java.util.HashMap;

/**
 * 560. Subarray Sum Equals K
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 */
public class p560_SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            // pre表示从0到i的元素累加和
            pre = pre + nums[i];
            // 检查是否存在子数组和为k，pre-k表示某个从0到x位置的累加和
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
