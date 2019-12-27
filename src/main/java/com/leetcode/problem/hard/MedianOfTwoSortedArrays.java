package com.leetcode.problem.hard;

/**
 *
 * 03 Longest Substring Without Repeating Characters
 *
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively
 *
 * Find the median of the two sorted arrays
 *
 * The overall run time complexity should be O(log (m+n))
 *
 * You may assume nums1 and nums2 cannot be both empty
 *
 *
 * Input: nums1 = [1, 2]    nums2 = [3, 4]
 *
 * Output: The median is (2 + 3) / 2 = 2.5
 *
 */

public class MedianOfTwoSortedArrays {

    /**
     * 思路(LeetCode): 将两个数组nums1和nums2分别分为两个部分
     *
     *             left_nums1             |             right_nums1
     * nums1[0] nums1[1] ... nums1[i - 1] | nums1[i] nums1[i + 1] ... nums1[m - 1]
     *
     *             left_nums2             |             right_nums2
     * nums2[0] nums2[1] ... nums2[j - 1] | nums2[j] nums2[j + 1] ... nums2[n - 1]
     *
     * 如果可以获得i和j, 使得:
     *     len(left_nums1 + left_nums2) = len(right_nums1 + right_nums2)
     *     max(left_nums1 + left_nums2) <= min(right_nums1 + right_nums2)
     * 成立, 那么:
     *     median = (max(left_nums1 + left_nums2) + min(right_nums1 + right_nums2)) / 2
     *
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        /**
         * 保证 n <= m
         *
         * 因为, 获得结果需要确保两个条件:
         *
         * 1. i + j = m - i + n + j(or: m - i + n - j + 1);
         * 2. nums1[i - 1] <= nums2[j], nums2[j - 1] <= nums1[j]
         *
         * 因此对于 n >= m, i = 0 ~ m, j = (m + n + 1)/2 - i
         *
         */
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        // 展开二分查找
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums1[i] < nums2[j - 1]) {
                iMin = i + 1;
            } else if (i > iMin && nums2[j] < nums1[i - 1]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                // 考虑左半部分边界条件
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums2[j - 1], nums1[i - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                // 考虑右半部分边界条件
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        System.out.println(median.findMedianSortedArrays(nums1, nums2));
    }

    /**
     *
     * 首个思路：按照两有序数组序列排序，取中位数
     * 复杂度：O(max(m,n))
     *
     * public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     *         int m = nums1.length;
     *         int n = nums2.length;
     *         double result;
     *         int i = 0, j = 0;
     *         ArrayList<Integer> nums = new ArrayList<Integer>();
     *         while (i < m && j < n) {
     *             if (nums1[i] <= nums2[j]) {
     *                 nums.add(nums1[i]);
     *                 i++;
     *             } else {
     *                 nums.add(nums2[j]);
     *                 j++;
     *             }
     *         }
     *         if (i == m) {
     *             for (int k = j; k < n; k++) {
     *                 nums.add(nums2[k]);
     *             }
     *         }
     *         if (j == n) {
     *             for (int k = i; k < m; k++) {
     *                 nums.add(nums1[k]);
     *             }
     *         }
     *         if ((m + n) % 2 == 0) {
     *             result = (nums.get((m + n) / 2.0) + nums.get((m + n) / 2 - 1)) / 2.0;
     *         } else {
     *             result = nums.get((m + n - 1) / 2);
     *         }
     *         return result;
     *     }
     */

}
