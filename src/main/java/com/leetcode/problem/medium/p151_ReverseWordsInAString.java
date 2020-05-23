package com.leetcode.problem.medium;

import static java.lang.System.out;

/**
 * 151. Reverse Words in a String
 * Given an input string, reverse the string word by word.
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the
 *
 */
public class p151_ReverseWordsInAString {

    public static String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if ("".equals(strs[i]) || " ".equals(strs[i])) {
                continue;
            }
            res.append(strs[i].trim());
            if (i != 0) {
                res.append(" ");
            }
        }
        return res.toString().trim();
    }

}
