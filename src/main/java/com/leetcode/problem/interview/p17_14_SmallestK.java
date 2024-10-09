package com.leetcode.problem.interview;

/**
 * https://leetcode.cn/problems/smallest-k-lcci/description/
 *
 * Design an algorithm to find the smallest K numbers in an array.
 *
 * Example:
 *
 * Input:  arr = [1,3,5,7,2,4,6,8], k = 4
 * Output:  [1,2,3,4]
 * 
 * Note:
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 */
public class p17_14_SmallestK {

    private int k;

    public int[] smallestK(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[]{};
        }
        int[] res = new int[k];
        this.k = k;
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int key = partition(arr, left, right);
            if (key == k) {
                return;
            }
            if (key > k) {
                quickSort(arr, left, key - 1);
            } else {
                quickSort(arr, key + 1, right);
            }
        }
    }

    private int partition(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left < right) {
            while (arr[right] >= tmp && left < right) {
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] <= tmp && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }

}
