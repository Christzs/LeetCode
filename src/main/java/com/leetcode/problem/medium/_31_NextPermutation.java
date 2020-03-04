package com.leetcode.problem.medium;

/**
 * 31. Next Permutation
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order.
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 */
public class _31_NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length > 1) {
            int left = nums.length - 1, right, temp;
            // 从数组末尾开始寻找逆序的前一位数字
            while (left > 0) {
                if (nums[left] > nums[left - 1]) {
                    break;
                }
                left--;
            }
            // 整个数组均为逆序，返回顺序排列
            if (left == 0) {
                reverseNums(0, nums.length - 1, nums);
            } else {
                // right为逆序的第一位数字，left为逆序开始的前一位数字
                right = left--;
                // 寻找逆序排列中刚号比right位置大的数字
                while (right < nums.length - 1) {
                    if (nums[right] >= nums[left] && nums[right + 1] <= nums[left]) {
                        break;
                    }
                    right++;
                }
                // 交换两个数字
                reverse(nums, left, right);
                // 转换逆序为顺序
                reverseNums(left + 1, nums.length - 1, nums);
            }
        }
    }

    private void reverse(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverseNums(int begin, int end, int[] nums) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = temp;
        }
    }
}
