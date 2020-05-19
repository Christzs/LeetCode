package com.leetcode.problem.easy;

/**
 * 680. Valid Palindrome II
 *
 * Given a non-empty string s, you may delete at most one character.
 * Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 */
public class p680_ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        if (s == null || "".equals(s) || s.length() == 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (c1 == c2) {
                left++;
                right --;
            } else {
                boolean flag1 = true, flag2 = true;
                for (int i = left, j = right - 1; i < j; i++, j--) {
                    char c3 = s.charAt(i);
                    char c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = left + 1, j = right; i < j; i++, j--) {
                    char c3 = s.charAt(i);
                    char c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }

}
