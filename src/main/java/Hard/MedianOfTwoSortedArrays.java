package Hard;

import java.util.ArrayList;

/**
 * @Description
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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0, j = 0; i < m && j < n;) {
            if (nums1[i] <= nums2[j]) {
                nums.add(nums1[i]);
                i++;
            } else {

            }
        }
    }

}
