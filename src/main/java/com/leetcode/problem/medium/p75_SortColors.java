package com.leetcode.problem.medium;

/**
 * 75. Sort Colors
 * Given an array with n objects colored red, white or blue
 * , sort them in-place so that objects of the same color are adjacent
 * , with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class p75_SortColors {

    public void sortColors(int[] nums) {

        // cur指向遍历的当前数字，p0指向0表示的最右边界，p2指向2的最左边界
        int p0 = 0, cur = 0, p2 = nums.length - 1;
        int tmp;

        while (cur <= p2) {
            if (nums[cur] == 0) {
                tmp = nums[p0];
                // 交换cur和p0指向的数字，并同时向右移动一位
                nums[p0++] = nums[cur];
                nums[cur++] = tmp;
            } else if (nums[cur] == 2) {
                tmp = nums[p2];
                // 交换cur和p0指向的数字，并p2向左移动一位
                nums[p2--] = nums[cur];
                // cur指针不动，因为交换过来的数字还未进行验证
                nums[cur] = tmp;
            } else {
                // cur指向1, 指针右移
                cur++;
            }
        }
    }

}
