package com.leetcode.problem.easy;

/**
 * 35. Search Insert Position
 *
 * Given a sorted array and a target value, return the index if the target is found.
 *
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 */
public class p35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums[0] > target) {
            return 0;
        }

        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        int left = 0, right = nums.length - 1;

        // 二分法寻找目标
        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        while (left < nums.length) {
            if (nums[left] < target) {
                if (left == nums.length - 1) {
                    return nums.length;
                }
                left++;
            } else {
                return left;
            }
        }
        return nums.length;
    }

}
