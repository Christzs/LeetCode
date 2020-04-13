package com.leetcode.problem.medium;

import java.util.*;

/**
 * 39. Combination Sum
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target)
 *
 * Find all unique combinations in candidates where the candidate numbers sums to target.
 *
 */
public class p39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        int length = candidates.length;

        // 排序数组
        Arrays.sort(candidates);

        // 深度优先搜索
        dfs(candidates, length, target, 0, new ArrayDeque<>(), res);

        return res;

    }

    private void dfs(int[] candidates,
                     int length,
                     int residue,
                     int begin,
                     Deque<Integer> path,
                     List<List<Integer>> res) {

        // 终止条件
        if (residue == 0) {
            res.add(new ArrayList<>(path));
        }

        for (int i = begin; i < length; i++) {
            // 差小于0, 无法继续搜索
            if (residue - candidates[i] < 0) {
                break;
            }
            // 添加节点
            path.addLast(candidates[i]);
            // 向下搜索
            dfs(candidates, length, residue - candidates[i], i, path, res);
            // 回溯
            path.removeLast();
        }

    }


}
