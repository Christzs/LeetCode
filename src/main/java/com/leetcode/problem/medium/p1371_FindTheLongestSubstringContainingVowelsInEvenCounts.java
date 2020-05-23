package com.leetcode.problem.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 1371. Find the Longest Substring Containing Vowels in Even Counts
 * Given the string s, return the size of the longest substring containing each vowel an even number of times.
 * That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.
 *
 * Input: s = "eleetminicoworoep"
 * Output: 13
 * Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.
 */
public class p1371_FindTheLongestSubstringContainingVowelsInEvenCounts {
    public int findTheLongestSubstring(String s) {
        int res = 0;
        if (s == null || "".equals(s)) {
            return res;
        }
        int len = s.length();
        // 5个元音字母，就是00000-11111，pos用于存放2^5种状态, 0对应奇数，1对应偶数
        int[] pos = new int[1<<5];
        // 用-1填充是怕00000这种情况，避免混淆
        Arrays.fill(pos, -1);
        int status = 0;
        pos[0] = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            /*-------------开始----------------*/
            // 在这里主要是用当前字符去更新上一个子串的状态，因为当前这个字符可能是元音字符或者不是
            // 用异或的原因就是，我们只关心奇偶性，异或相同为0，不同为1，那么只要将上一个状态对应位与
            // 1 << （0-4）一下就可以了。也就是第一次来是奇数，那么第二次就是偶数，第三次是奇数...
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            /*--------------结束---------------*/
            // 得到一个新的状态值，如果这个状态值作索引对应位置的值大于0，
            // 那么就说明第一次出现该值的位置到当前位置所对应的字符串就是当前
            // 符合要求的子串，这是因为如果在i的位置和j的位置对应的状态值相等，
            // 那么这两个子串的奇偶性肯定相等,既然奇偶性相同了，那么中间范围对应的子串就是我们要求的
            // （奇数-奇数=偶数，偶数-偶数=偶数）
            // 同时我们要和之前的子串比较一下长度，因为我们要取最长的
            if (pos[status] >= 0) {
                res = Math.max(res, i + 1 - pos[status]);
            } else {
                //pos只存放每一个状态值第一个出现的位置
                pos[status] = i + 1;
            }
        }
        return res;
    }

}
