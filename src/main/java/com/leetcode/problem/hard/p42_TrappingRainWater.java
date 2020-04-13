package com.leetcode.problem.hard;

/**
 * 42. Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class p42_TrappingRainWater {

    public int trap(int[] height) {

        int res = 0;

        int len = height.length;

        if (len == 0) {
            return res;
        }

        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = height[0];
        for (int i = 1; i < len; i ++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < len; i++) {
            res += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return res;
    }


}
