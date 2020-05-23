package com.leetcode.problem.medium;

/**
 * 50. Pow(x, n)
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn)
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 */
public class p50_PowXN {

    public static double myPow(double x, int n) {
        long N = n;

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double res = 1;
        double tmp = x;

        // (x^n)^2 = x^(2*n)
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                res = res * tmp;
            }
            tmp = tmp * tmp;
        }

        return res;
    }

}
