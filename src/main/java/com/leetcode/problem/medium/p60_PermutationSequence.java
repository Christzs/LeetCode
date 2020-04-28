package com.leetcode.problem.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.System.out;

/**
 * 60. Permutation Sequence
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * 解法：
 *  假设n= 6k = 373，
 *  那么nums = [1, 2, 3, 4, 5, 6]每个数字作为开头，各有5！种排列方法，则共有6！(6 * 5!)种排列方法
 *      1. 故当k = 373时，全排列的第一个数字为nums[k/5!] = 4
 *      2. 数组删除 4, 此时 nums = [1, 2, 3, 5, 6]; k %= 5! = 12 ;表示4开头的第12种排列
 *      3. 接下来就是在 nums 中找第 12 个全排列，重复 1，2 步即可
 *
 */
public class p60_PermutationSequence {

    public static String getPermutation(int n, int k) {

        int[] nums = new int[n];

        for (int i = 1; i < n + 1; i++) {
            nums[i - 1] = i;
        }

        StringBuilder res = new StringBuilder();

        // 数组下标从0开始，k-1
        k--;

        int factor;

        for (int i = 0; i < n; i++) {
            factor = factorial(n - i - 1);
            res.append(nums[k / factor]);
            remove(nums, n - i, k / factor);
            k %= factor;
        }

        return res.toString();

    }

    private static void remove(int[] nums, int len, int k) {
        while (k < len - 1) {
            nums[k] = nums[k + 1];
            k++;
        }
    }

    private static int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }

}
