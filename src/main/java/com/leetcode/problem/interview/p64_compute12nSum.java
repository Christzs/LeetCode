package com.leetcode.problem.interview;

/**
 * 面试题64. 求1+2+…+n
 *
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class p64_compute12nSum {

    public int sumNums(int n) {
        int i = 1;
        try {
            i = i % n;
            return n + sumNums(n - 1);
        } catch (Exception e) {
            return n;
        }
    }

}
