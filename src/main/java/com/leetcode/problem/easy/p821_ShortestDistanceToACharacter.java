package com.leetcode.problem.easy;

/**
 * 821. Shortest Distance to a Character
 * Given a string s and a character c that occurs in s,
 * return an array of integers answer where answer.length == s.length
 * and answer[i] is the distance from index i to the closest occurrence of character c in s.
 *
 * The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "loveleetcode", c = "e"
 * Output: [3,2,1,0,1,0,0,1,2,2,1,0]
 * Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
 * The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
 * The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
 * For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5,
 * but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
 * The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
 *
 * Example 2:
 *
 * Input: s = "aaab", c = "b"
 * Output: [3,2,1,0]
 */
public class p821_ShortestDistanceToACharacter {

    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        int m = 0;
        boolean flag = false;
        // 从左至右搜索第一个c
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                res[i] = 0;
                flag = true;
                m = 0;
            } else {
                res[i] = flag ? ++m : s.length();
            }
        }
        m = 0;
        flag = false;
        // 从右至左搜索第一个c
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                res[i] = 0;
                flag = true;
                m = 0;
            } else {
                res[i] = Math.min(flag ? ++m : s.length(), res[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        p821_ShortestDistanceToACharacter shortestDistanceToACharacter = new p821_ShortestDistanceToACharacter();
        System.out.println(shortestDistanceToACharacter.shortestToChar("loveleetcode", 'e'));
    }

}
