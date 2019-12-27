package com.leetcode.problem.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 03 Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters
 *
 * Input: "abcabcbb"
 *
 * Output: 3    ("abc")
 *
 */

public class LongestSubStringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, left = 0, right = 0, length;
        int sLength = s.length();
        if (sLength == 0) {
            return maxLength;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (; right < sLength; right++) {
            Character character = s.charAt(right);
            if (map.containsKey(character)) {
                left = Math.max(left, map.get(character) + 1);
            }
            maxLength = Math.max(maxLength, right - left + 1);
            map.put(character, right);
        }
        return maxLength;
    }

}
