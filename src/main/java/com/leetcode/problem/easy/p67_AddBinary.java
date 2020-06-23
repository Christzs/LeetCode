package com.leetcode.problem.easy;

import java.util.Map;

/**
 * 67. Add Binary
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 */
public class p67_AddBinary {

    public String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();

        int n = Math.max(a.length(), b.length()), carry = 0;

        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            result.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            result.append('1');
        }

        return result.reverse().toString();

    }

}
