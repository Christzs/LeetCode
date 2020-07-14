package com.leetcode.problem.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 350. Intersection of Two Arrays II
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 */
public class p350_IntersectionOfTwoArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int n : nums1) {
            numsMap.put(n, numsMap.getOrDefault(n, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int n : nums2) {
            if (numsMap.containsKey(n)) {
                res.add(n);
                int cnt = numsMap.get(n);
                if (cnt == 1) {
                    numsMap.remove(n);
                } else {
                    numsMap.replace(n, cnt - 1);
                }
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

}
