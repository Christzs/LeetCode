package com.leetcode.problem.medium;

import com.leetcode.problem.NestedInteger;

/**
 * Example 1:
 *
 * Input: s = "324"
 * Output: 324
 * Explanation: You should return a NestedInteger object which contains a single integer 324.
 *
 * Example 2:
 *
 * Input: s = "[123,[456,[789]]]"
 * Output: [123,[456,[789]]]
 * Explanation: Return a NestedInteger object containing a nested list with 2 elements:
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 *     i.  An integer containing value 456.
 *     ii. A nested list with one element:
 *          a. An integer containing value 789
 *
 */
public class p385_MiniParser {

    int index = 0;

    public NestedInteger deserialize(String s) {
        // list
        if (s.charAt(index) == '[') {
            index++;
            NestedInteger ni = new NestedInteger();
            while (s.charAt(index) != ']') {
                ni.add(deserialize(s));
                if (s.charAt(index) == ',') {
                    index++;
                }
            }
            index++;
            return ni;
        } else {
            boolean flag = false;
            if (s.charAt(index) == '-') {
                flag = true;
                index++;
            }
            int num = 0;
            // 计算数字
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + s.charAt(index) - 48;
                index++;
            }
            num = flag ? -num : num;
            return new NestedInteger(num);
        }
    }

    public static void main(String[] args) {
        p385_MiniParser miniParser = new p385_MiniParser();
        String s = "[123,[456,[789]]]";
        System.out.println(miniParser.deserialize(s));
    }


}
