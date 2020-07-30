package com.leetcode.problem.medium;

/**
 * 343. Integer Break
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 *
 * Example :
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
public class p343_IntegerBreak {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i < dp.length; i++) {
            int cur = 0;
            for (int j = 1; j < i; j++) {
                cur = Math.max(cur, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = cur;
        }
        return dp[n];
    }

}
