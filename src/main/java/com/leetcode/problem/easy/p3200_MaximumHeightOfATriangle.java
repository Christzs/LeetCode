package com.leetcode.problem.easy;

/**
 * 3200. 三角形的最大高度
 * 给你两个整数 red 和 blue，分别表示红色球和蓝色球的数量。你需要使用这些球来组成一个三角形，满足第 1 行有 1 个球，第 2 行有 2 个球，第 3 行有 3 个球，依此类推。
 * 每一行的球必须是 相同 颜色，且相邻行的颜色必须 不同。返回可以实现的三角形的 最大 高度。
 *
 * 示例 1：
 * 输入： red = 2, blue = 4
 * 输出： 3
 *
 * 示例 2：
 * 输入： red = 2, blue = 1
 * 输出： 2
 *
 * 示例 3：
 * 输入： red = 1, blue = 1
 * 输出： 1
 *
 * 示例 4：
 * 输入： red = 10, blue = 1
 * 输出： 2
 *
 * 提示：1 <= red, blue <= 100
 *
 * @author tianzhongshi
 * @date 2024-10-15 19:29
 */
public class p3200_MaximumHeightOfATriangle {

    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(getHeight(red, blue), getHeight(blue, red));
    }

    private int getHeight(int first, int second) {
        int res = 0;
        int tier = 1;
        while (Math.max(first, second) >= tier) {
            if (tier % 2 == 1) {
                if (first - tier < 0) {
                    break;
                } else {
                    first -= tier;
                    res++;
                    tier++;
                }
            } else {
                if (second - tier < 0) {
                    break;
                } else {
                    second -= tier;
                    res++;
                    tier++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        p3200_MaximumHeightOfATriangle solution = new p3200_MaximumHeightOfATriangle();
        System.out.println(solution.maxHeightOfTriangle(4, 4));
    }
}
