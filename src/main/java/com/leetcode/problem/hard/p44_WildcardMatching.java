package com.leetcode.problem.hard;

/**
 * 44. Wildcard Matching
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 */
public class p44_WildcardMatching {

    public static boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        dp[0][0] = true;
        // p字符串开头存在*，则匹配空字符串
        for (int i = 1; i <= lenP; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[0][i] = true;
        }
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[lenS][lenP];
    }

    public static void main(String[] args) {
        p44_WildcardMatching.isMatch("s", "ss*");
    }

}
