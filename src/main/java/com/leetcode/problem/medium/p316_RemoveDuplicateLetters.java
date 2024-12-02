package com.leetcode.problem.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 *
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * 提示：
 * 1 <= s.length <= 104, s 由小写英文字母组成
 *
 * @author tianzhongshi
 * @date 2024-12-02 20:05
 */
public class p316_RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] rawChars = s.toCharArray();
        Map<Character, LinkedList<Integer>> letterRecords = new HashMap<>(26);
        for (int index = 0; index < rawChars.length; index++) {
            char c = rawChars[index];
            if (!letterRecords.containsKey(c)) {
                letterRecords.put(c, new LinkedList<>());
            }
            letterRecords.get(c).add(index);
        }
        boolean[] visit = new boolean[26];
        StringBuilder result = new StringBuilder();
        for (char c : rawChars) {
            if (!visit[c - 'a']) {
                while(result.length() > 0 && c < result.charAt(result.length() - 1)) {
                    char last = result.charAt(result.length() - 1);
                    if (letterRecords.get(last).size() > 0) {
                        visit[last - 'a'] = false;
                        result.deleteCharAt(result.length() - 1);
                    } else {
                        break;
                    }
                }
                result.append(c);
                visit[c - 'a'] = true;
            }
            letterRecords.get(c).pop();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        p316_RemoveDuplicateLetters solution = new p316_RemoveDuplicateLetters();
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
    }

}
