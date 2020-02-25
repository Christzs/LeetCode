package com.leetcode.problem.easy;

/**
 * 27. Remove Element
 *
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * input:
 * nums = [0,1,2,2,3,0,4,2]
 *
 * output:
 * 5 -> 0, 1, 3, 0, 4
 */
public class _27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        _27_RemoveElement removeElement = new _27_RemoveElement();
        System.out.println(removeElement.removeElement(nums, val));
    }

}
