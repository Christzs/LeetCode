package com.leetcode.problem.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/description/
 *
 * 78. Subsets
 *
 * Given an integer array nums of unique elements, return all possible subsets
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * 提示：1 <= nums.length <= 10 / -10 <= nums[i] <= 10 / nums 中的所有元素 互不相同
 *
 * @author tianzhongshi
 * @date 2024-10-11 21:33
 */
public class p78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 加一个空集
        res.add(new ArrayList<>());
        // 遍历数组
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        p78_Subsets subsets = new p78_Subsets();
        System.out.println(subsets.subsets(nums));
    }

}
