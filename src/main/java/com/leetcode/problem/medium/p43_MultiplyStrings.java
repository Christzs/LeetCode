package com.leetcode.problem.medium;

/**
 * 43. Multiply Strings
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 */
public class p43_MultiplyStrings {


    public String multiply(String num1, String num2) {

        if (isEmpty(num1) || isEmpty(num2)) {
            return "";
        }

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int maxLen = num1.length() + num2.length();
        int[] res = new int[maxLen];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                res[maxLen - (i + j) - 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        for (int i = 0; i < maxLen - 1; i++) {
            if (res[i] > 9) {
                int tmp = res[i];
                res[i] = tmp % 10;
                res[i + 1] += (tmp / 10);
            }
        }

        StringBuilder builder = new StringBuilder();

        int end = res[0] == 0? 1 : 0;

        for (int i = maxLen - 1; i >= end; i--) {
            builder.append(res[i]);
        }

        return builder.toString();

    }

    private boolean isEmpty(String s) {
        return s == null || "".equals(s);
    }


    public static void main(String[] args) {

        p43_MultiplyStrings multiplyStrings = new p43_MultiplyStrings();

        System.out.println(multiplyStrings.multiply("123", "456"));
    }

}
