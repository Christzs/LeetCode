package com.leetcode.problem.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4], [3,4], [2,3], [1,2], [1,3], [1,4]
 * ]
 */
public class p77_Combinations {

    List<List<Integer>> result = new LinkedList<>();

    int n;

    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return result;
    }

    private void backtrack(int first, LinkedList<Integer> cur) {
        if (cur.size() == k) {
            result.add(new LinkedList<>(cur));
            return;
        }
        for (int i = first; i <= n; i++) {
            cur.add(i);
            backtrack(i + 1, cur);
            cur.removeLast();
        }
    }

}
