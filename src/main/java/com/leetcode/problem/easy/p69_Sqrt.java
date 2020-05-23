package com.leetcode.problem.easy;

/**
 * 69. Sqrt(x)
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 */
public class p69_Sqrt {

    public int mySqrt(int x) {
        int l = 0, r = x, res = 0;
        while (l <= r) {
            int mid = (l + r) / 2 ;
            if ((long) mid * mid <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

}
