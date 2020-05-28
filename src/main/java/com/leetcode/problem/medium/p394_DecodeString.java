package com.leetcode.problem.medium;

import java.util.Stack;

/**
 * 394. Decode String
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is:
 *
 * k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class p394_DecodeString {

    public String decodeString(String s) {

        if (s == null || "".equals(s)) {
            return s;
        }

        int left = 0, right = 0;
        String result = "";
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if ('[' == c) {
                stack.push(c);
                left++;
                continue;
            }
            if (']' == c) {
                stack.push(c);
                right++;
                if (left >= right) {
                    String order = "";
                    String tmp = order;
                    char cur = stack.pop();
                    while (cur >= 65) {
                        if (cur == ']') {
                            cur = stack.pop();
                            continue;
                        }
                        if (cur == '[') {
                            cur = stack.pop();
                            break;
                        }
                        tmp = cur + tmp;
                        cur = stack.pop();
                    }
                    int cnt = cur - 48, i = 1;
                    while (cur >= 48 && !stack.isEmpty()) {
                        cur = stack.pop();
                        if (cur == '[') {
                            break;
                        }
                        if (cur >= 65) {
                            stack.push(cur);
                            break;
                        }
                        cnt += ((cur - 48) * ((int) Math.pow(10, i)));
                        i++;
                    }

                    order = "";
                    for (int j = 0; j < cnt; j++) {
                        order += tmp;
                    }
                    left--;
                    right--;
                    if (left == right) {
                        result += order;
                    }
                    if (left > right) {
                        for (char c2 : order.toCharArray()) {
                            stack.push(c2);
                        }
                    }
                }
            } else {
                if (left == 0 && right == 0 && c >=65) {
                    result += c;
                } else {
                    stack.push(c);
                }
            }
        }
        return result;
    }

}
