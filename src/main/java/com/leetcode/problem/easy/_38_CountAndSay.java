package com.leetcode.problem.easy;

/**
 * 38. Count and Say
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * You can do so recursively, in other words from the previous member read off the digits
 * , counting the number of digits in groups of the same digit.
 *
 *
 */
public class _38_CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay(n - 1);
        StringBuilder builder = new StringBuilder();
        char[] chars = pre.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            int term = chars[i];
            while (i < chars.length && term == chars[i]) {
                count++;
                i++;
            }
            i--;
            builder.append(count)
                    .append(Character.getNumericValue(term));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        _38_CountAndSay countAndSay = new _38_CountAndSay();
        System.out.println(countAndSay.countAndSay(5));
    }
}
