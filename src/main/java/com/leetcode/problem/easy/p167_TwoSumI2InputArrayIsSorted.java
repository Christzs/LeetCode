package com.leetcode.problem.easy;

/**
 * 167. Two Sum II - Input array is sorted
 *  * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *  *
 *  * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *  *
 *  * Input: numbers = [2,7,11,15], target = 9
 *  * Output: [1,2]
 *  * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class p167_TwoSumI2InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        if (len == 0) {
            return new int[]{};
        }
        int left = 0, right = numbers.length - 1, sum;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right + 1};
    }

}
