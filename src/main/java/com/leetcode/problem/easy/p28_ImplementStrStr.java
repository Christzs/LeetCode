package com.leetcode.problem.easy;

/**
 * 28. Implement strStr()
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * input:
 * haystack = "aaaaa", needle = "bba"
 *
 * output:
 * -1
 */
public class p28_ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if ("".equals(haystack)) {
            return -1;
        }

        char[] hayChars = haystack.toCharArray();

        char[] needChars = needle.toCharArray();

        int hayLen = hayChars.length;

        int needLen = needChars.length;

        for (int i = 0; i < hayLen - needLen + 1; i++) {
            if (hayChars[i] == needChars[0]) {
                for (int j = 0; j < needLen; j++) {
                    if (hayChars[i + j] != needChars[j]) {
                        break;
                    }
                    if (j == needLen - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

}
