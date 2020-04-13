package com.leetcode.problem.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 30. Substring with Concatenation of All Words
 *
 * You are given a string, s, and a list of words, words, that are all of the same length.
 *
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * input:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 *
 * output:
 * [0,9]
 *
 *
 */
public class _30_SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();

        if (s.length() == 0 || words.length == 0) {
            return res;
        }

        // 使用 hashmap, 提升字符创对比效率
        HashMap<String, Integer> wordsCountMap = new HashMap<>();

        int wordLength = words[0].length();

        int wordNum = words.length;

        for (String word : words) {
            wordsCountMap.put(word, wordsCountMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            // 滑动窗口，初始为起点 i
            int left = i, right = i, count = 0;
            // 与 wordsCountMap 对比
            HashMap<String, Integer> needWord = new HashMap<>();
            while (right + wordLength <= s.length()) {
                // 右移 wordLength, 获取字符串
                String cur = s.substring(right, right + wordLength);
                // 窗口右测移动 wordLength
                right += wordLength;
                // 获得的字符串 cur 与 words 中单词匹配
                if (wordsCountMap.containsKey(cur)) {
                    // 存入 needWord
                    needWord.put(cur, needWord.getOrDefault(cur, 0) + 1);
                    // 计数加1
                    count++;
                    // 如果已匹配字符串超出 words 中规定的数量
                    while (needWord.getOrDefault(cur, 0) > wordsCountMap.getOrDefault(cur, 0)) {
                        // 窗口左移
                        String next = s.substring(left, left + wordLength);
                        left += wordLength;
                        // 计数减1
                        count--;
                        // 该字符串计数减1
                        needWord.put(next, needWord.get(next) - 1);

                    }
                    // 条件符合
                    if (count == wordNum) {
                        res.add(left);
                    }
                }
                // 获得的字符串 cur 与 words 中单词不匹配
                else {
                    count = 0;
                    left = right;
                    needWord.clear();
                }
            }
        }


        return res;
    }

}
