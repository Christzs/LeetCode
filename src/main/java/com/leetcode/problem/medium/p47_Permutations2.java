package com.leetcode.problem.medium;

import java.util.*;

import static java.lang.System.out;

/**
 * 47. Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class p47_Permutations2 {

    private List<List<Integer>> res;

    private Integer len;

    private int[] target;

    public List<List<Integer>> permuteUnique(int[] nums) {

        // 排序数组
        Arrays.sort(nums);

        // 初始化
        this.target = nums;
        this.res = new ArrayList<>();

        // 递归回溯
        permutation(new ArrayDeque<Integer>(), new boolean[target.length]);

        return res;
    }

    private void permutation(Deque path, boolean[] used) {
        if (path.size() == target.length) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < target.length; i++) {
            if (i > 0 && target[i - 1] == target[i] && !used[i - 1]) {
                continue;
            }
            // used数组用于标记已被使用的数字
            if (!used[i]) {
                path.addLast(target[i]);
                used[i] = true;
                permutation(path, used);
                used[i] = false;
                path.removeLast();
            }
        }
    }


}
