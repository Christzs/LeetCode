package com.leetcode.problem.medium;

import java.util.HashMap;

/**
 * 567. Permutation in String
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 *  
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * 解法：下边自己想的解法复杂化了，直接生成一个存储26个字母的数组，通过滑动窗口即可解决。
 *
 */
public class p567_PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {

        if (isEmpty(s1) || isEmpty(s2)) {
            return false;
        }

        HashMap<Character, Integer> charMap = new HashMap<>();
        HashMap<Character, Integer> tmp = new HashMap<>();

        char[] chars = s1.toCharArray();
        for (char c : chars) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        int point = 0, left = 0;

        for (; point < s2.length(); point++) {
            char curChar = s2.charAt(point);
            if (charMap.containsKey(curChar)) {
                tmp.put(curChar, tmp.getOrDefault(curChar, 0) + 1);
                if (tmp.get(curChar) > charMap.get(curChar)) {
                    while (left <= point) {
                        char removeChar = s2.charAt(left++);
                        if (!tmp.containsKey(removeChar)) {
                            continue;
                        }
                        tmp.put(removeChar, tmp.get(removeChar) - 1);
                        if (tmp.get(curChar).equals(charMap.get(curChar))) {
                            break;
                        }
                    }
                }
                if (checkIfFind(charMap, tmp)) {
                    return true;
                }
            } else {
                left = point;
                tmp.clear();
            }
        }

        return checkIfFind(charMap, tmp);

    }

    private static boolean checkIfFind(HashMap<Character, Integer> charMap, HashMap<Character, Integer> tmp) {
        if (charMap.keySet().size() != tmp.keySet().size()) {
            return false;
        }
        for (char key : charMap.keySet()) {
            if (!charMap.get(key).equals(tmp.getOrDefault(key, -1))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isEmpty(String s) {
        return s == null || "".equals(s);
    }

}
