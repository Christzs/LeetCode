package com.leetcode.problem.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. Subarray Sums Divisible by K
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 *
 * Example 1:
 *
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 */
public class p974_SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0, same = 0;
        for (int num : A) {
            sum += num;
            // 当被除数为负数时，取模结果为负，+K可将module纠正
            int module = ((sum % K) + K) % K;
            // 查询当前sum之前，同余的前缀和有多少
            same = map.getOrDefault(module, 0);
            // 累加该结果
            res += same;
            // 将当前余数记录仅map
            map.put(module, same + 1);
        }
        return res;
    }

}
