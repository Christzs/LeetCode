package com.leetcode.problem.easy;

/**
 * 58. Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Input: "Hello World"
 * Output: 5
 */
public class _58_LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        s = s.trim();

        if (s == null || "".equals(s)) {
            return 0;
        }

        return s.length() - 1 - s.lastIndexOf(" ");

    }

}
