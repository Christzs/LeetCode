package com.leetcode.problem.hard;

/**
 * 41. First Missing Positive
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Input: [1,2,0]
 * Output: 3
 */
public class _41_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 1;
        }
        int[] check = new int[len];
        // 大于等于1的和小于等于len的值放到check数组对应位置
        // 负数及大于len的则丢弃
        for (int i : nums) {
            if (i >= 1 && i <= len) {
                check[i - 1] = i;
            }
        }
        // check数组某位置为0, 则表示该位置的值不存在
        for (int j = 0; j < len; j++) {
            if (check[j] == 0) {
                return j + 1;
            }
        }
        // check数组被填满，表示最小正整数为nums数组最大值+1
        return len + 1;
    }

}
