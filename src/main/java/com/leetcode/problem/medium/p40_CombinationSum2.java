package com.leetcode.problem.medium;

import java.util.*;

/**
 * @author zst
 * @date 2020-03-18
 */
public class p40_CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

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
            // i > begin, 避免同一层级（一次for循环）出现相同的元素
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 添加节点
            path.addLast(candidates[i]);
            // 向下搜索
            dfs(candidates, length, residue - candidates[i], i + 1, path, res);
            // 回溯
            path.removeLast();
        }

    }

}
