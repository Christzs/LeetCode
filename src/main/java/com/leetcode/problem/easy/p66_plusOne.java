package com.leetcode.problem.easy;

/**
 * 66. Plus One
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123
 */
public class p66_plusOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length, sum, carry = 0;
        if (len == 0) {
            return digits;
        }
        for (int i = len - 1; i >= 0; i--) {
            sum = i == len -1 ? digits[i] + 1 : digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry != 0) {
            int[] tmp = new int[len + 1];
            tmp[0] = carry;
            int i = 1;
            for (int n : digits) {
                tmp[i++] = n;
            }
            return tmp;
        }
        return digits;
    }

}
