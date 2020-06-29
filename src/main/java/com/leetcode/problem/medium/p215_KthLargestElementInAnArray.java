package com.leetcode.problem.medium;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 */
public class p215_KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        int target = nums.length - k;

        int index = partition(nums, 0, nums.length - 1);
        while (index != target) {
            if (index > target) {
                index = partition(nums, 0, index - 1);
            } else {
                index = partition(nums,index + 1, nums.length - 1);
            }
        }
        return nums[index];
    }

    public int partition(int[] nums, int left, int right) {
        int cur = nums[left];
        while (left < right) {
            while (nums[right] >= cur && left < right) {
                right--;
            }
            nums[left] = nums[right];
            while (nums[left] <= cur && left < right) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = cur;
        return left;
    }

}
