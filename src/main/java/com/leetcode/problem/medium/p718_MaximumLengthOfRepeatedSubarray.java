package com.leetcode.problem.medium;

/**
 * @author zst
 * @date 2020-07-01
 */
public class p718_MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            int len = Math.min(lenB, lenA - i);
            int maxLen = maxLength(A, B, i, 0, len);
            res = Math.max(res, maxLen);
        }
        for (int i = 0; i < B.length; i++) {
            int len = Math.min(lenA, lenB - i);
            int maxLen = maxLength(A, B, 0, i, len);
            res = Math.max(res, maxLen);
        }

        return res;
    }

    private int maxLength(int[] A, int[] B, int a, int b, int len) {

        int res = 0, tmp = 0;
        for (int i = 0; i < len; i++) {
            if (A[a + i] == B[b + i]) {
                tmp++;
            } else {
                tmp = 0;
            }
            res = Math.max(res, tmp);
        }
        return res;

    }

}
