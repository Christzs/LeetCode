package com.leetcode.problem.medium;

/**
 * 1248. Count Number of Nice Subarrays
 *
 * Given an array of integers nums and an integer k.
 * A subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation:
 * The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 *
 */
public class p1248_CountNumberOfNiceSubarrays {

    public static int numberOfSubarrays(int[] nums, int k) {

        int left = 0, right = 0, oddNumsCnt = 0, res = 0;
        while (right < nums.length) {
            if ((nums[right++] & 1) == 1) {
                oddNumsCnt++;
            }
            if (oddNumsCnt == k) {
                int tmp = right;
                // 统计第k个奇数右侧的偶数个数
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }
                int rightEvenCnt = right - tmp;
                int leftEvenCnt = 0;
                // 统计第1个奇数左侧的偶数个数
                while ((nums[left] & 1) == 0) {
                    leftEvenCnt++;
                    left++;
                }
                // 第 1 个奇数左边的 leftEvenCnt 个偶数都可以作为优美子数组的起点
                // (因为第1个奇数左边可以1个偶数都不取，所以起点的选择有 leftEvenCnt + 1 种）
                // 第 k 个奇数右边的 rightEvenCnt 个偶数都可以作为优美子数组的终点
                // (因为第k个奇数右边可以1个偶数都不取，所以终点的选择有 rightEvenCnt + 1 种）
                // 所以该滑动窗口中，优美子数组左右起点的选择组合数为 (leftEvenCnt + 1) * (rightEvenCnt + 1)
                res += (rightEvenCnt + 1) * (leftEvenCnt + 1);

                // left 指向的是第 1 个奇数，因为该区间已经统计完了，因此 left 右移一位，oddCnt--
                left++;
                oddNumsCnt--;
            }
        }


        return res;
    }



}
