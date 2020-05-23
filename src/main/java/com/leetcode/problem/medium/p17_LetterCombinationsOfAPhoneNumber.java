package com.leetcode.problem.medium;

import java.util.*;

/**
 *
 * 17 Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive(like a mobile phone keyboard)
 *
 * return all possible letter combinations that the number could represent
 *
 * Note that 1 does not map to any letters
 *
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 *
 * 解法：
 *
 * 回溯思想，1字母连接下一组字母的方式相同，利用递归方式，终止条件为连接了所有数字下的字母
 *
 */

/**
 * 直接解法
 */
public class p17_LetterCombinationsOfAPhoneNumber {

    private static final HashMap<Integer, List<String>> keyBoard = new HashMap<>(8);

    static {
        keyBoard.put(2, Arrays.asList("a", "b", "c"));
        keyBoard.put(3, Arrays.asList("d", "e", "f"));
        keyBoard.put(4, Arrays.asList("g", "h", "i"));
        keyBoard.put(5, Arrays.asList("j", "k", "l"));
        keyBoard.put(6, Arrays.asList("m", "n", "o"));
        keyBoard.put(7, Arrays.asList("p", "q", "r", "s"));
        keyBoard.put(8, Arrays.asList("t", "u", "v"));
        keyBoard.put(9, Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {

        if (digits == null || "".equals(digits)) {
            return Collections.emptyList();
        }

        if (digits.length() == 1) {
            return keyBoard.get(Integer.valueOf(digits));
        }

        List<String> letters = new ArrayList<>();

        char[] digitsArray = digits.toCharArray();

        for (int i = 0; i < digitsArray.length - 1; i++) {
            List<String> l1 = letters.size() == 0 ? keyBoard.get(digitsArray[i] - 48) : letters;
            List<String> l2 = keyBoard.get(digitsArray[i + 1] - 48);
            letters = getTwoNumberCombination(l1, l2);
        }

        return letters;

    }

    private List<String> getTwoNumberCombination(List<String> l1, List<String> l2) {
        List<String> res = new ArrayList<>();
        for (String s1 : l1) {
            for (String s2 : l2) {
                res.add(s1 + s2);
            }
        }
        return res;
    }

}


/**
 * 回溯算法
 */
class Solution {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }

    public void backtrack(String combination, String next_digit) {
        // 递归终止条件
        if (next_digit.length() == 0) {
            output.add(combination);
        } else {
            // 取当前数字
            String theDigit = next_digit.substring(0, 1);
            // 取数字相应字母集合
            String lettersOfDigit = phone.get(theDigit);
            for (int i = 0; i < lettersOfDigit.length(); i++) {
                // 取当前字母
                String theLetter = lettersOfDigit.substring(i, i +1);
                // 连接当前字母, 使用剩余数字递归
                backtrack(combination + theLetter, next_digit.substring(1));
            }
        }

    }

}
