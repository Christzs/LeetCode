package com.leetcode.problem.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * Given n pairs of parentheses
 *
 * write a function to generate all combinations of well-formed parentheses.
 *
 *
 * 解法：回溯法
 */
public class p22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        getRes(res, "", 0, 0, n);
        return res;

    }

    private void getRes(List<String> res, String cur, int open, int close, int n) {

        // 长度为2n时返回
        if (cur.length() == n * 2) {
            res.add(cur);
            return;
        }

        // 左括号仍可配对
        if (open < n) {
            getRes(res, cur + "(", open + 1, close, n);
        }

        // 保证右括号数量等于左括号数量
        if (close < open) {
            getRes(res, cur + ")", open, close + 1, n);
        }
    }


}
