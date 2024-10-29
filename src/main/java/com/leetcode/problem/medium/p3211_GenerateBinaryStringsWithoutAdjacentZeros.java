package com.leetcode.problem.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 3211. 生成不含相邻零的二进制字符串
 *
 *  给你一个正整数 n。如果一个二进制字符串 x 的所有长度为 2 的子字符串中包含 至少 一个 "1"，则称 x 是一个 有效字符串。
 *  返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。
 *
 *  示例 1：
 *  输入： n = 3
 *  输出： ["010","011","101","110","111"]
 *  解释：长度为 3 的有效字符串有："010"、"011"、"101"、"110" 和 "111"。
 *
 *  示例 2：
 *  输入： n = 1
 *  输出： ["0","1"]
 *  解释：长度为 1 的有效字符串有："0" 和 "1"。
 *
 *  提示：1 <= n <= 18
 *
 * @author tianzhongshi
 * @date 2024-10-29 21:18
 */
public class p3211_GenerateBinaryStringsWithoutAdjacentZeros {

    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        append(n, "", result);
        return result;
    }

    private void append(int n, String str, List<String> result) {
        if (n == 0) {
            result.add(str);
            return;
        }
        int len = str.length();
        if (len == 0 || str.charAt(len - 1) == '1') {
            append(n - 1, str + "1", result);
            append(n - 1, str + "0", result);
        } else {
            append(n - 1, str + "1", result);
        }
    }

    public static void main(String[] args) {
        p3211_GenerateBinaryStringsWithoutAdjacentZeros solution = new p3211_GenerateBinaryStringsWithoutAdjacentZeros();
        System.out.println(solution.validStrings(3));
    }

}
