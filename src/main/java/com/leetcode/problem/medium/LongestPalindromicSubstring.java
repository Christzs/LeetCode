package com.leetcode.problem.medium;

/**
 *
 * 05 Longest Palindromic Substring
 *
 *
 * Given a string s, find the longest palindromic substring in s
 *
 * You may assume that the maximum length of s is 1000
 *
 *
 * Input: "babad"
 *
 * Output: "bab"
 *
 */

public class LongestPalindromicSubstring {

    private final Character divide = '#';


    //使用Manacher算法
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        // 使用 # 分割字符串
        stringBuilder.append(divide);
        for (int i = 0; i < len; i++) {
            stringBuilder.append(s.charAt(i));
            stringBuilder.append(divide);
        }
        int newLen = stringBuilder.length();
        char[] chars = stringBuilder.toString().toCharArray();
        int[] p = new int[newLen];
        int palindromeCentre = 0;
        int rightBoundary = 0;
        int maxPalindromeLength = 0;
        String longestPalindrome = stringBuilder.substring(0, 1);
        for (int i = 0; i < newLen; i++) {
            // i 位于 rightBoundary 左边，返回 中心对称位置的回文长度与p[i]可能最大值间的最小值，否则置 1
            p[i] = rightBoundary > i ? Math.min(p[2 * palindromeCentre - i], rightBoundary - i) : 1;
            // 对位置 i 展开中心扩散搜索
            while (i + p[i] < newLen && i - p[i] > 0) {
                if (chars[i + p[i]] == chars[i - p[i]]) {
                    p[i]++;
                } else {
                    break;
                }
            }
            // 回文长度正价，更新rightBoundary和palindromeCentre
            if (i + p[i] > rightBoundary) {
                rightBoundary = i + p[i];
                palindromeCentre = i;
            }
            // 更新最长回文串
            if (maxPalindromeLength < p[i]) {
                maxPalindromeLength = p[i];
                longestPalindrome = stringBuilder.substring(palindromeCentre - p[i] + 1, palindromeCentre + p[i]).replaceAll(divide.toString(), "");
            }
        }
        return longestPalindrome;
    }

}
