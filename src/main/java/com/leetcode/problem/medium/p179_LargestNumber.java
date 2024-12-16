package com.leetcode.problem.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 179. 最大数
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * 提示：1 <= nums.length <= 100、0 <= nums[i] <= 109
 */
public class p179_LargestNumber {

    public String largestNumber(int[] nums) {
        String[] boxedNums = IntStream.of(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(boxedNums, (x, y) -> {
            return (y + x).compareTo(x + y);
        });
        if (boxedNums[0].equals("0")) {
            return "0";
        }
        return String.join("", boxedNums);
    }

    public static void main(String[] args) {
        p179_LargestNumber solution = new p179_LargestNumber();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(solution.largestNumber(nums));
    }
}