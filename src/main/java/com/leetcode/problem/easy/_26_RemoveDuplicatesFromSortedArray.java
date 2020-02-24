package com.leetcode.problem.easy;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * Given a sorted array nums
 *
 * remove the duplicates in-place such that each element appear only once and return the new length
 *
 * input:
 * nums = [0,0,1,1,1,2,2,3,3,4]
 * output:
 * 5 -> 0, 1, 2, 3, 4
 *
 */
public class _26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        int len = nums.length;

        if (len == 0 || len == 1) {
            return len;
        }
        int cur = 0, point = 0;
        while (point < len - 1) {
            if (nums[point] == nums[point + 1]) {
                point++;
            } else {
                nums[cur++] = nums[point++];
            }
            if (point == len - 1) {
                nums[cur++] = nums[point];
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        _26_RemoveDuplicatesFromSortedArray sortedArray = new _26_RemoveDuplicatesFromSortedArray();
        System.out.println(sortedArray.removeDuplicates(nums));
    }

}
