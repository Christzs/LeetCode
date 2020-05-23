package com.leetcode.problem.hard;

import java.util.HashMap;
import java.util.Set;

/**
 * 76. Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */

public class p76_MinimumWindowSubstring {

    private Set<Character> targetCharSet;

    public String minWindow(String s, String t) {
        String res = "";
        if ("".equals(s) || "".equals(t)) {
            return res;
        }
        HashMap<Character, Integer> targetMap = new HashMap<>();
        this.targetCharSet = targetMap.keySet();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> searchMap = new HashMap<>();
        int left = 0, right = -1;
        while (right < s.length()) {
            right++;
            if ( right < s.length() && targetCharSet.contains(s.charAt(right))) {
                searchMap.put(s.charAt(right), searchMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (checkIfHasTarget(searchMap, targetMap) && left < right) {
                String newRes = s.substring(left, right + 1);
                res = "".equals(res) ? newRes : (newRes.length() > res.length() ? res : newRes);
                char charAtLeft = s.charAt(left);
                if (searchMap.containsKey(charAtLeft)) {
                    searchMap.put(charAtLeft, searchMap.get(charAtLeft) - 1);
                }
                left++;
            }
        }

        return res;
    }

    private boolean checkIfHasTarget(HashMap<Character, Integer> searchMap, HashMap<Character, Integer> targetMap) {
        if (searchMap.keySet().size() == targetCharSet.size()) {
            for (Character charKey : targetCharSet) {
                if (searchMap.get(charKey) < targetMap.get(charKey)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        p76_MinimumWindowSubstring minimumWindowSubstring = new p76_MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindowSubstring.minWindow(s, t));
    }

}
