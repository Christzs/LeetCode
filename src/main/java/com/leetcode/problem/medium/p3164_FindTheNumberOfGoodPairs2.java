package com.leetcode.problem.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/find-the-number-of-good-pairs-ii/description/?envType=daily-question&envId=2024-10-11
 *
 *  3164. 优质数对的总数 II
 *
 *  给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
 *  如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）*
 *  返回 优质数对 的总数。
 *
 *  示例 1：
 *  输入：nums1 = [1,3,4], nums2 = [1,3,4], k = 1
 *  输出：5
 *  解释：5个优质数对分别是 (0, 0), (1, 0), (1, 1), (2, 0), 和 (2, 2)。
 *
 *  示例 2：
 *  输入：nums1 = [1,2,4,12], nums2 = [2,4], k = 3
 *  输出：2
 *  解释：2个优质数对分别是 (3, 0) 和 (3, 1)。
 *
 *  提示：
 *  1 <= n, m <= 105 / 1 <= nums1[i], nums2[j] <= 106 / 1 <= k <= 103
 *
 * @author tianzhongshi
 * @date 2024-10-11 11:50
 */
public class p3164_FindTheNumberOfGoodPairs2 {

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long res = 0;
        Map<Integer, Integer> num1Count = new HashMap<>();
        Map<Integer, Integer> num2Count = new HashMap<>();

        int max1 = 0;
        for (int num : nums1) {
            num1Count.put(num, num1Count.getOrDefault(num, 0) + 1);
            max1 = Math.max(max1, num);
        }

        for (int num : nums2) {
            num2Count.put(num, num2Count.getOrDefault(num, 0) + 1);
        }

        for (int num2 : num2Count.keySet()) {
            for (int x = num2 * k; x <= max1; x += num2 * k) {
                if (num1Count.containsKey(x)) {
                    res += (long) num1Count.get(x) * num2Count.get(num2);
                }
            }
        }
        return res;
    }

}
