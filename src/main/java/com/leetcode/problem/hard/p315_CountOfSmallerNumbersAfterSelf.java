package com.leetcode.problem.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. Count of Smaller Numbers After Self
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example:
 *
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 */
public class p315_CountOfSmallerNumbersAfterSelf {
    private List<Integer> res;

    private int[] index;

    public List<Integer> countSmaller(int[] nums) {

        this.res = new ArrayList<>();
        this.index = new int[nums.length];
        if (nums.length == 0 ) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            res.add(0);
            index[i] = i;
        }
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        mergeArray(nums, left, mid, right);
    }

    private void mergeArray(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[index[i]] > nums[index[j]]) {
                tmp[k] = index[i];
                res.set(index[i], res.get(index[i]) + (right - j + 1));
                k++;
                i++;
            } else {
                tmp[k++] = index[j++];
            }
        }
        while (j <= right) {
            tmp[k++] = index[j++];
        }
        while (i <= mid) {
            tmp[k++] = index[i++];
        }
        for (int x = 0; x < tmp.length; x++) {
            index[left + x] = tmp[x];
        }
    }
}
