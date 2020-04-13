package com.leetcode.problem.medium;

/**
 *
 * 11 Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai)
 *
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0)
 *
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 *
 * Output: 49 [(2,8), (9,7)]
 *
 * - 解法：指定左右指针从两边依次向中间移动，移动条件为 *移动较短的一边*，直至两指针相遇
 * - 每次移动后记录面积，`maxArea = maxArea > newArea ? maxArea : newArea`
 *
 */

public class p11_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int leftIndex = 0, rightIndex = height.length - 1, maxArea = 0;
        while (leftIndex < rightIndex) {
            maxArea = Math.max(maxArea, Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex));
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxArea;
    }

}
