package com.leetcode.problem.easy;

/**
 *
 * 14 Longest Common Prefix
 *
 *
 * Write a function to find the longest common prefix string amongst an array of strings
 *
 * If there is no common prefix, return an empty string ""
 *
 *
 * Input: ["flower","flow","flight"]
 *
 * Output: "fl"
 *
 *
 * 解法：
 *
 * 遍历字符串数组，依次两两寻找字符串共有前缀，直至两两字符串不拥有共同前缀或遍历结束
 */
public class _14_LongestCommonPrefix {

    private static final String EMPTY_STRING = "";

    public String getCmmonPrefix(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] charOfA = a.toCharArray();
        char[] charOfB = b.toCharArray();
        int len = charOfA.length;
        if (charOfA.length > charOfB.length) {
            len = charOfB.length;
        }
        for (int i = 0; i < len; i++) {
            if (charOfA[i] == charOfB[i]) {
                sb.append(charOfA[i]);
            } else {
                break;
            }
        }
        if (sb.length() == 0) {
            return EMPTY_STRING;
        }
        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return EMPTY_STRING;
        }
        String common = strs[0];
        for (int index = 1; index < len; index ++) {
            common = getCmmonPrefix(common, strs[index]);
            if (EMPTY_STRING.equals(common)) {
                break;
            }
        }
        return common;
    }

}
