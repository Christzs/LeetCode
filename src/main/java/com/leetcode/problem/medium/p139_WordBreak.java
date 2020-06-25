package com.leetcode.problem.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Example :
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class p139_WordBreak {

    private int minLength;

    private int maxLength;

    private int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        this.minLength = Integer.MIN_VALUE;
        this.maxLength = Integer.MAX_VALUE;
        this.memo = new int[s.length()];
        Arrays.fill(memo, -1);
        for (String word : wordDict) {
            int length = word.length();
            minLength = Math.min(length, minLength);
            maxLength = Math.max(length, maxLength);
        }
        return search(0, wordSet, s);
    }

    private boolean search(int pos, HashSet<String> wordSet, String s) {

        if (pos == s.length()) {
            return true;
        }
        if (memo[pos] != -1) {
            return memo[pos] != 0;
        }
        for (int i = pos; i < s.length(); i++) {
            if ((i - pos + 1) > maxLength) {
                return false;
            }
            if ((i - pos + 1) >= minLength && (wordSet.contains(s.substring(pos, i + 1)))) {
                if (search(i + 1, wordSet, s)) {
                    memo[pos] = 1;
                    return true;
                }
            }
        }
        memo[pos]= 0;
        return false;
    }

}
