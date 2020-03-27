package com.leetcode.problem.medium;

import java.util.*;

/**
 * 46. Permutations
 *
 * Given a collection of distinct integers, return all possible permutations
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class _42_Permutations {

    private List<List<Integer>> res;

    private Integer len;

    private int[] target;

    public List<List<Integer>> permute(int[] nums) {

        this.target = nums;

        initResultList();

        permutation(new ArrayDeque<Integer>(), new boolean[target.length]);

        return res;
    }

    private void permutation(Deque path, boolean[] used) {
        if (path.size() == target.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < target.length; i++) {
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

    private void initResultList() {

        len = doFactorial(target.length);

        this.res = new ArrayList<>(len);;
    }

    private int doFactorial(int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        return n * doFactorial(n - 1);
    }

}
