package com.leetcode.problem.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 18. Four sum
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 *
 * Find all unique quadruplets in the array which gives the sum of target
 *
 * The solution set must not contain duplicate quadruplets.
 *
 *
 * 解法：
 *
 * 每次循环固定一个数字，变换为三数之和，获得结果后继续遍历，遇到相同数字跳过避免重复
 */
public class _18_FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0 || len < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < len - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int start = j + 1;
                        int end = len - 1;
                        int sum = target - nums[i] - nums[j];
                        while (end > start) {
                            int temp = nums[start] + nums[end];
                            if (temp == sum) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                                while (end > start && nums[start] == nums[start + 1]) {
                                    start++;
                                }
                                while (end > start && nums[end] == nums[end - 1]) {
                                    end--;
                                }
                                start++;
                                end--;
                            } else if (sum > temp) {
                                start++;
                            } else {
                                end--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

}
