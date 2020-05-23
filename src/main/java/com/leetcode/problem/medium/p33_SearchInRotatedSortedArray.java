package com.leetcode.problem.medium;

/**
 * 33. Search in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search.
 *
 * If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
public class p33_SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        // 搜索旋转位置
        int loc = searchRotateLoc(nums);

        if (nums[loc] == target) {
            return loc;
        }
        if (loc == 0) {
            return search(nums, target, 0, nums.length - 1);
        }

        if (target >= nums[0]) {
            return search(nums, target, 0, loc);
        }
        return search(nums, target, loc, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int searchRotateLoc(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 数组升序，未旋转
        if (nums[left] < nums[right]) {
            return 0;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // 找到旋转点
                return mid + 1;
            } else {
                // mid是否在旋转后的左半部分
                if (nums[mid] >= nums[left]) {
                    // 在左半部分，左窗口右移
                    left = mid + 1;
                } else {
                    // 在右半部分，右窗口左移
                    right = mid - 1;
                }
            }

        }

        return 0;

    }

}
