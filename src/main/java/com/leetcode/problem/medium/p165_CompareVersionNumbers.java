package com.leetcode.problem.medium;

/**
 * Given two version numbers, version1 and version2, compare them.
 *
 * Version numbers consist of one or more revisions joined by a dot '.'.
 * Each revision consists of digits and may contain leading zeros.
 * Every revision contains at least one character.
 * Revisions are 0-indexed from left to right, with the leftmost revision being revision 0,
 * the next revision being revision 1, and so on.
 * For example 2.5.33 and 0.1 are valid version numbers.
 *
 * To compare version numbers, compare their revisions in left-to-right order.
 * Revisions are compared using their integer value ignoring any leading zeros.
 * This means that revisions 1 and 001 are considered equal.
 * If a version number does not specify a revision at an index, then treat the revision as 0.
 * For example, version 1.0 is less than version 1.1 because their revision 0s are the same,
 * but their revision 1s are 0 and 1 respectively, and 0 < 1.
 *
 * Return the following:
 *
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 *
 * Example 1:
 *
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Example 2:
 *
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Example 3:
 *
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Example 4:
 *
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * Example 5:
 *
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 *
 */
public class p165_CompareVersionNumbers {

    private static final String VERSION_SEG = "\\.";

    /**
     * @return
     * If version1 < version2, return -1.
     * If version1 > version2, return 1.
     * Otherwise, return 0.
     */
    public int compareVersion(String version1, String version2) {
        String[] version1StringArray = version1.trim().split(VERSION_SEG);
        String[] version2StringArray = version2.trim().split(VERSION_SEG);
        int maxIndex = Math.max(version1StringArray.length, version2StringArray.length);
        // 默认相等
        int compareFlag = 0;
        int ver1Num, ver2Num;
        for (int i = 0; i < maxIndex; i++) {
            // 获取version1索引i位置的数值
            ver1Num = parseVersionIntValue(i, version1StringArray);
            // 获取version2索引i位置的数值
            ver2Num = parseVersionIntValue(i, version2StringArray);
            if (ver1Num > ver2Num) {
                return 1;
            }
            if (ver1Num < ver2Num) {
                return -1;
            }
        }
        return compareFlag;
    }

    private int parseVersionIntValue(int index, String[] versionStringArray) {
        if (index < versionStringArray.length) {
            return Integer.parseInt(versionStringArray[index]);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        p165_CompareVersionNumbers compareVersionNumbers = new p165_CompareVersionNumbers();
        String version1 = "7.5.2.4";
        String version2 = "7.5.3";
        System.out.println(compareVersionNumbers.compareVersion(version1, version2));
    }

}
