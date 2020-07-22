package com.leetcode.problem.offer;

/**
 * @author zst
 * @date 2020-07-22
 */
public class p11_MinNumberOfRotateArray {

    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1, mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

}
