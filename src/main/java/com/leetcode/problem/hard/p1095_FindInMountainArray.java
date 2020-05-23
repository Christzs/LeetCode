package com.leetcode.problem.hard;

import com.leetcode.problem.MountainArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1095. Find in Mountain Array
 *
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 *
 * 如果不存在这样的下标 index，就请返回 -1。
 *
 *  
 *
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 *
 * 首先，A.length >= 3
 *
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 *
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * Input: array = [1,2,3,4,5,3,1], target = 3
 * Output: 2
 * Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
 *
 */
public class p1095_FindInMountainArray {

    private static int errorRes = -1;

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr.length() == 0) {
            return -1;
        }
        // 寻找最大数值的索引
        int maxIndex = getMaxIndex(mountainArr);
        if (target > mountainArr.get(maxIndex)
                || (target < mountainArr.get(0) && target < mountainArr.get(mountainArr.length() - 1))) {
            return errorRes;
        }
        // 左半部分二分查找，找到就返回
        int leftSearchIndex = -1;
        if (target >= mountainArr.get(0)) {
            leftSearchIndex = search(mountainArr, 0, maxIndex, target, false);
        }
        // 右半部分二分查找，找到就返回
        return leftSearchIndex == -1 ?  search(mountainArr, maxIndex + 1, mountainArr.length(), target, true) : leftSearchIndex;
    }

    private static int search(MountainArray mountainArray, int left, int right, int target, boolean desc) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mountainArray.get(mid) == target) {
                return mid;
            }
            if (mountainArray.get(mid) < target) {
                left = desc ? left : mid + 1;
                right = desc ? mid - 1 : right;
            } else {
                left = desc ? mid + 1 : left;
                right = desc ? right : mid - 1;
            }

        }
        return errorRes;
    }

    private static int getMaxIndex(MountainArray mountainArray) {
        int left = 0, right = mountainArray.length(), mid;

        while (left < right) {
            mid = (left + right) / 2;
            if ((mid - 1) >= 0 && mountainArray.get(mid) < mountainArray.get(mid - 1)) {
                right = mid;
                continue;
            }
            if ((mid - 1) >= 0 && mountainArray.get(mid) > mountainArray.get(mid - 1)) {
                if ((mid + 1) < mountainArray.length() && mountainArray.get(mid) < mountainArray.get(mid + 1)) {
                    left = mid;
                } else if ((mid + 1) < mountainArray.length() && mountainArray.get(mid) > mountainArray.get(mid + 1)){
                    return mid;
                }
            }
        }
        return errorRes;
    }

    public static void main(String[] args) {
        MountainArray mountainArray = new MountainArray();
        mountainArray.add(1);
        mountainArray.add(2);
        mountainArray.add(3);
        mountainArray.add(4);
        mountainArray.add(5);
        mountainArray.add(3);
        mountainArray.add(1);
        System.out.println(findInMountainArray(2, mountainArray));
    }

}
