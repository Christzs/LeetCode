package com.leetcode.problem.interview;

/**
 * 面试题51. 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 解法：归并排序，同时统计逆序对
 */
public class p51_ReversePairOfArrays {

    public int reversePairs(int[] nums) {
        int len = nums.length, res = 0;
        if (len < 2) {
            return res;
        }
        int[] tmp = new int[nums.length];
        return reversePairs(nums, 0, len - 1, tmp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] tmp) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int leftPairs = reversePairs(nums, left, mid, tmp);
        int rightPairs = reversePairs(nums, mid + 1, right, tmp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        int mergeParis = merge(nums, left, mid, right, tmp);
        return leftPairs + rightPairs + mergeParis;
    }

    private int merge(int[] nums, int left, int mid, int right, int[] tmp) {

        for (int i = left; i <= right; i++) {
            tmp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;

        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = tmp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = tmp[i];
                i++;
            } else if (tmp[i] <= tmp[j]) {
                nums[k] = tmp[i];
                i++;
            } else {
                nums[k] = tmp[j];
                j++;
                // 当tmp[i] > tmp[j], 那么从下标i至下标mid，均与tmp[j]构成逆序对
                count += (mid - i + 1);
            }
        }
        return count;

    }

}
