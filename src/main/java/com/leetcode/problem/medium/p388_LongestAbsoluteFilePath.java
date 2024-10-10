package com.leetcode.problem.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-absolute-file-path/
 *
 * Example 1:
 *
 * Input: input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
 * Output: 20
 * Explanation: We have only one file, and the absolute path is "dir/subdir2/file.ext" of length 20.
 *
 * Example 2:
 *
 * Input: input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 * Output: 32
 * Explanation: We have two files:
 * "dir/subdir1/file1.ext" of length 21
 * "dir/subdir2/subsubdir2/file2.ext" of length 32.
 * We return 32 since it is the longest absolute path to a file.
 *
 * Example 3:
 *
 * Input: input = "a"
 * Output: 0
 * Explanation: We do not have any files, just a single directory named "a".
 */
public class p388_LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        // 存储每个层级的目录长度
        Map<Integer, Integer> dirDepthLength = new HashMap<>();
        // 记录当前最大结果
        int longestPath = 0;
        // 记录已遍历的长度
        int curNodeLength = 0;
        // 记录当前层级, 0为根目录
        int depth = 0;
        // 初始化索引
        int index = 0;
        while (index < input.length()) {
            char c = input.charAt(index);
            if (input.charAt(index) == '\n') {
                if (curNodeLength > 0) {
                    dirDepthLength.put(depth, curNodeLength);
                }
                index++;
                depth = 0;
                curNodeLength = 0;
            }

            if (input.charAt(index) == '\t') {
                index++;
                // \t为层级标志
                depth++;
                continue;
            }

            if (input.charAt(index) == '.') {
                // 计算当前路径长度
                while (index < input.length() && input.charAt(index) != '\n') {
                    curNodeLength++;
                    index++;
                }
                int curPathLength = curNodeLength + depth;
                for (int i = depth - 1; i >= 0; i--) {
                    curPathLength += dirDepthLength.getOrDefault(i, 0);
                }
                longestPath = Math.max(longestPath, curPathLength);
                continue;
            }
            curNodeLength++;
            index++;
        }
        return longestPath;
    }

    public static void main(String[] args) {
        p388_LongestAbsoluteFilePath longestAbsoluteFilePath = new p388_LongestAbsoluteFilePath();
        String input = "a";
        System.out.println(longestAbsoluteFilePath.lengthLongestPath(input));
    }



}
