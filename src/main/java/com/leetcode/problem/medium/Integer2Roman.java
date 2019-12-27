package com.leetcode.problem.medium;

/**
 *
 * 12 Integer to Roman
 *
 * Given an integer, convert it to a roman numeral
 *
 * Input is guaranteed to be within the range from 1 to 3999
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * Input:   3     4     9     58       1994
 *
 * Output: III   IV    IX    LVIII    MCMXCIV
 *
 */

public class Integer2Roman {

    public String intToRoman(int num) {
        // 罗马数字表示，个位数不超过3位
        // 特殊数字为4、9及其倍数
        final String[] romans = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        final int[] romans2nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder res = new StringBuilder();
        int index = romans2nums.length - 1;
        while (num > 0) {
            // 寻找数组romans2nums中比num小的最大数字
            while (num < romans2nums[index]) {
                index--;
            }
            res.append(romans[index]);
            // 减去已计算的部分
            num -= romans2nums[index];
        }
        return res.toString();
    }

}
