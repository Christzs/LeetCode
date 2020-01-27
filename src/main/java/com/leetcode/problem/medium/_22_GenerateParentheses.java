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
 */
public class _22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        getRes(res, "", 0, 0, n);
        return res;

    }

    private void getRes(List<String> res, String cur, int open, int close, int len) {

        if (cur.length() == len * 2) {
            res.add(cur);
            return;
        }

        if (open < len) {
            getRes(res, cur + "(", open + 1, close, len);
        }
        if (close < open) {
            getRes(res, cur + ")", open, close + 1, len);
        }
    }


}
