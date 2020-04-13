package com.leetcode.problem.medium;

/**
 * 29. Divide Two Integers
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 */
public class p29_DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        boolean flag = dividend < 0 ^ divisor < 0;
        dividend = dividend > 0? -dividend : dividend;
        divisor = divisor > 0? -divisor : divisor;
        int res = 0;
        while (dividend <= divisor) {
            int temRes = -1;
            int temDiv = divisor;
            // 倍增被除数，提升效率
            while (dividend < (temDiv << 1)) {
                // 避免溢出
                if (temDiv <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                temRes = temRes << 1;
                temDiv = temDiv << 1;
            }
            dividend = dividend - temDiv;
            res+=temRes;

        }
        // 溢出处理
        if (res == Integer.MIN_VALUE && !flag) {
            return Integer.MAX_VALUE;
        }
        return flag ? res : -res;
    }

    public static void main(String[] args) {
        p29_DivideTwoIntegers divideTwoIntegers = new p29_DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(2147483647, 1));
    }


}
