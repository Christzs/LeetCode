package com.leetcode.problem.medium;

import java.util.Arrays;

/**
 * 1300. Sum of Mutated Array Closest to Target
 * Given an integer array arr and a target value target,
 * return the integer value such that when we change all the integers larger than value in the given array to be equal to value,
 * the sum of the array gets as close as possible (in absolute difference) to target.
 *
 * In case of a tie, return the minimum such integer.
 *
 * Notice that the answer is not neccesarilly a number from arr.
 *
 * Example:
 *
 * Input: arr = [4,9,3], target = 10
 * Output: 3
 * Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's the optimal answer.
 */
public class p1300_SumOfMutatedArrayClosestToTarget {

    public int findBestValue(int[] arr, int target) {
        // arr升序排序
        Arrays.sort(arr);

        // 遍历数组
        // 如果当前遍历的元素>target/剩余遍历个数，返回
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            double x = (double) (target - sum) / (arr.length - i);
            if (arr[i] >= x) {
                int tmp = (target - sum) / (arr.length - i);
                return x - tmp > 0.5 ? tmp + 1 : tmp;
            }
            sum += arr[i];
        }

        return arr[arr.length - 1];
    }

}
