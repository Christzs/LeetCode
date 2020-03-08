package com.leetcode.problem.medium;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order.
 *
 * Find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 */
public class _34_FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }

        int left = 0, right = nums.length - 1, loc = -1;

        // 二分法寻找目标
        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                loc = mid;
                break;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (loc == -1) {
            return new int[]{-1, -1};
        }

        int begin = loc, end = loc;

        // 寻找左边界
        while (begin > 0) {
            if (nums[begin - 1] != target) {
                break;
            }
            begin--;
        }

        // 寻找右边界
        while (end < nums.length - 1) {
            if (nums[end + 1] != target) {
                break;
            }
            end++;

        }

        return new int[]{begin, end};

    }

}
