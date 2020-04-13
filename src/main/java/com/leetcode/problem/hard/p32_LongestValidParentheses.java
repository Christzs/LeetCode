package com.leetcode.problem.hard;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')'
 *
 * Find the length of the longest valid (well-formed) parentheses substring
 *
 * Input:
 *  "(()"
 * Output:
 *  2 ==> "()"
 *
 */
public class _32_LongestValidParentheses {

    private static final char OPEN_PAREN = '(';

    private static final char CLOSE_PAREN = ')';

    public int longestValidParentheses(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        char[] parens = s.toCharArray();

        int maxLength = 0;

        // -1 推入栈底，用于计算字符串长度
        stack.push(-1);
        for (int i = 0; i < parens.length; i++) {
            if (parens[i] == OPEN_PAREN) {
                // 左括号下标推入栈中
                stack.push(i);
            }
            if (parens[i] == CLOSE_PAREN) {
                // 弹出栈顶元素，匹配右括号
                stack.pop();
                // 栈为空，推入当前元素下标，用于计算字符串长度
                if (stack.empty()) {
                    stack.push(i);
                    continue;
                }
                // 当前下标与栈顶元素之差，为当前最长合法字符串长度
                maxLength = Math.max(i - stack.peek(), maxLength);
            }
        }

        return maxLength;
    }

}
