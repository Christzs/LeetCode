package com.leetcode.problem.medium;

/**
 * 55. Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Input: [2,3,1,1,4]
 * Output: true
 *
 * Input: [3,2,1,0,4]
 * Output: false
 *
 */
public class _55_JumpGame {

    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return true;
        }
        int maxJump = 0;
        int nextJump = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; ; j++) {
                if (j > nums[i] + i || j > len - 1) {
                    break;
                }
                if (nums[j] + j > maxJump) {
                    nextJump = j;
                    maxJump = nums[j] + j;
                }
            }
            if (maxJump == 0) {
                return false;
            }
            if (maxJump >= len - 1) {
                return true;
            }
            i = nextJump - 1;
            maxJump = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] s = new int[] {2,0};
        System.out.println(canJump(s));
    }

}
