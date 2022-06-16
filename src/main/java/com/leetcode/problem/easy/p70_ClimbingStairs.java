package com.leetcode.problem.easy;

/**
 * 70. Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 *
 * f(n) = f(n - 1) + f(n - 2)
 */
public class p70_ClimbingStairs {

    public int climbStairs(int n) {
        int pre1 = 1, pre2 = 2;
        if (n == 1) {
            return pre1;
        }
        if (n == 2) {
            return pre2;
        }
        int res = 0;
        n -= 2;
        while (n > 0) {
            res = pre1 + pre2;
            pre1 = pre2;
            pre2 = res;
            n--;
        }
        return res;
    }
}
