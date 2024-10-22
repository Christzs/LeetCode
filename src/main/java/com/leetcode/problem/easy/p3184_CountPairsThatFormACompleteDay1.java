package com.leetcode.problem.easy;

/**
 * 3184. 构成整天的下标对数目 I
 *
 * 给你一个整数数组 hours，表示以 小时 为单位的时间，返回一个整数，表示满足 i < j 且 hours[i] + hours[j] 构成整天的下标对 i, j 的数目。
 * 整天定义为时间持续时间是 24 小时的整数倍 。
 *
 * 例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。
 *
 * 示例 1：
 * 输入： hours = [12,12,30,24,24]
 * 输出： 2
 * 解释：构成整天的下标对分别是 (0, 1) 和 (3, 4)。
 *
 * 示例 2：
 * 输入： hours = [72,48,24,3]
 * 输出： 3
 * 解释：构成整天的下标对分别是 (0, 1)、(0, 2) 和 (1, 2)。
 *
 * 提示：1 <= hours.length <= 100; 1 <= hours[i] <= 10^9
 *
 * @author tianzhongshi
 * @date 2024-10-22 20:28
 */
public class p3184_CountPairsThatFormACompleteDay1 {

    public int countCompleteDayPairs(int[] hours) {
        int count = 0;
        for (int i = 0; i < hours.length - 1; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        p3184_CountPairsThatFormACompleteDay1 solution = new p3184_CountPairsThatFormACompleteDay1();
        System.out.println(solution.countCompleteDayPairs(new int[]{72,48,24,3}));
    }

}