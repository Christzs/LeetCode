package com.leetcode.problem.easy;

/**
 * 125. Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 */
public class p125_ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if (null == s || "".equals(s)) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char lc = s.charAt(left);
            if (!checkIsLetterOrDigit(lc)) {
                left++;
                continue;
            }
            char rc = s.charAt(right);
            if (!checkIsLetterOrDigit(rc)) {
                right--;
                continue;
            }
            if (!checkEqual(lc, rc)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean checkIsLetterOrDigit(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    private static boolean checkEqual(char c1, char c2) {
        if (Character.isDigit(c1)) {
            return c1 == c2;
        }
        return c1 == c2 || c1 + 32 == c2 || c1 == c2 + 32;
    }




}
