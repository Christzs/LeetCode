package com.leetcode.problem.easy;

import java.util.HashSet;

/**
 * 202. Happy Number
 *
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class p202_HappyNumber {

    public boolean isHappy(int n) {
        HashSet<Integer> sums = new HashSet<>();
        while (n != 1 && !sums.contains(n)) {
            sums.add(n);
            n = getQuadraticSum(n);
        }
        return n == 1;
    }

    private static int getQuadraticSum(int n) {
        int res = 0;
        while (n > 0) {
            int unit = n % 10;
            res += (unit * unit);
            n /= 10;
        }
        return res;
    }

}
