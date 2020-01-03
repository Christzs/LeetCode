package com.leetcode.problem.easy;

import java.util.Stack;

/**
 *
 * 20. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']'
 *
 * Determine if the input string is valid.
 *
 * An input string is valid if:
 *      Open brackets must be closed by the same type of brackets.
 *      Open brackets must be closed in the correct order.
 *      Note that an empty string is also considered valid.
 *
 *
 * Input: "([)]", "{[]}"
 * Output: false, true
 */
public class ValidParentheses {

    private static final char OPEN_PAREN = '(';

    private static final char CLOSE_PAREN = ')';

    private static final char OPEN_BRACE = '{';

    private static final char CLOSE_BRACE = '}';

    private static final char OPEN_BRACKET = '[';

    private static final char CLOSE_BRACKET = ']';

    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> parenStack = new Stack<>();
        char[] parens = s.toCharArray();
        for (int i = 0; i < parens.length; i++) {
            if (parens[i] == OPEN_PAREN || parens[i] == OPEN_BRACE || parens[i] == OPEN_BRACKET) {
                parenStack.push(parens[i]);
            }
            if (parens[i] == CLOSE_PAREN || parens[i] == CLOSE_BRACE || parens[i] == CLOSE_BRACKET) {
                if (!parenStack.empty() && checkMatch(parenStack.peek(), parens[i])) {
                    parenStack.pop();
                } else {
                    return false;
                }
            }
        }
        if (parenStack.empty()) {
            return true;
        }
        return false;
    }

    private boolean checkMatch(char open, char close) {
        switch (open) {
            case OPEN_PAREN:
                return close == CLOSE_PAREN;
            case OPEN_BRACE:
                return close == CLOSE_BRACE;
            case OPEN_BRACKET:
                return close == CLOSE_BRACKET;
            default:
                return false;
        }
    }
}
