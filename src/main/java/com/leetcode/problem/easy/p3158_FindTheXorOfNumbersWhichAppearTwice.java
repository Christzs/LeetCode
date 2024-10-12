package com.leetcode.problem.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/find-the-xor-of-numbers-which-appear-twice/?envType=daily-question&envId=2024-10-12">...</a>
 *
 * 3158. 求出出现两次数字的 XOR 值
 * 给你一个数组 nums ，数组中的数字 要么 出现一次，要么 出现两次。
 * 请你返回数组中所有出现两次数字的按位 XOR 值，如果没有数字出现过两次，返回 0 。
 * --
 * 示例 1：
 * 输入：nums = [1,2,1,3]
 * 输出：1
 * 解释：nums 中唯一出现过两次的数字是 1 。
 * --
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：nums 中没有数字出现两次。
 * --
 * 示例 3：
 * 输入：nums = [1,2,2,1]
 * 输出：3
 * 解释：数字 1 和 2 出现过两次。1 XOR 2 == 3 。
 * --
 * 提示：1 <= nums.length <= 50、1 <= nums[i] <= 50、nums 中每个数字要么出现过一次，要么出现过两次
 *
 * @author tianzhongshi
 * @date 2024-10-12 17:24
 */
public class p3158_FindTheXorOfNumbersWhichAppearTwice {

    public int duplicateNumbersXOR1(int[] nums) {
        Arrays.sort(nums);
        int xor = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                xor ^= nums[i];
            }
        }
        return xor;
    }

    public int duplicateNumbersXOR2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int xor = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                xor ^= num;
            } else {
                set.add(num);
            }
        }
        return xor;
    }

    public static void main(String[] args) {
        p3158_FindTheXorOfNumbersWhichAppearTwice find = new p3158_FindTheXorOfNumbersWhichAppearTwice();
        System.out.println(find.duplicateNumbersXOR1(new int[]{1, 2, 2, 1}));
    }

}