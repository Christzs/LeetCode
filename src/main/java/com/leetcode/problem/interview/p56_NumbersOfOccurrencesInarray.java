package com.leetcode.problem.interview;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * 解法：任何一个数字异或它自己都等于0，不同的数字异或后的结果，总有一位不为0
 */
public class p56_NumbersOfOccurrencesInarray {

    public int[] singleNumbers(int[] nums) {
        if (nums.length == 0) {
            return new int[2];
        }
        int firstXor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            firstXor = firstXor ^ nums[i];
        }

        int index = getBitIndex(firstXor);

        int res1 = 0, res2 = 0;
        for (int num : nums) {
            if (checkNumBit(num, index)) {
                res1 = res1 ^ num;
            } else {
                res2 = res2 ^ num;
            }
        }

        return  new int[]{res1, res2};
    }

    private boolean checkNumBit(int num, int index) {
        num = num >> index;
        return (num & 1) == 0;
    }

    private int getBitIndex(int firstXor) {
        int index = 0;
        while ((firstXor & 1) == 0) {
            index++;
            firstXor = firstXor >> 1;
        }
        return index;
    }

}
