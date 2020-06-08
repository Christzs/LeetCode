package com.leetcode.problem.medium;

import java.util.Map;

/**
 * 990. Satisfiability of Equality Equations
 * Given an array equations of strings that represent relationships between variables
 * , each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".
 *
 * Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
 *
 * Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.
 *
 *
 *
 * Example 1:
 *
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
 * There is no way to assign the variables to satisfy both equations.
 */
public class p990_SatisfiabilityOfEqualityEquations {

    private Map<Character, Integer> charInt;

    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String equation : equations) {
            if ('=' == equation.charAt(1)) {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }

        for (String equation : equations) {
            if ('!' == equation.charAt(1)) {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }

        return true;
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    private int find(int[] parent, int index) {
        while (parent[index] != index) {
            // 路径压缩
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }


}
