package com.leetcode.problem.interview;

/**
 * 16.18. Pattern Matching LCCI
 *
 * You are given two strings, pattern and value.
 * The pattern string consists of just the letters a and b, describing a pattern within a string.
 * For example, the string catcatgocatgo matches the pattern aabab (where cat is a and go is b).
 * It also matches patterns like a, ab, and b. Write a method to determine if value matches pattern.
 * a and b cannot be the same string.
 *
 * Example 1:
 *
 * Input:  pattern = "abba", value = "dogcatcatdog"
 * Output:  true
 * Example 2:
 *
 * Input:  pattern = "abba", value = "dogcatcatfish"
 * Output:  false
 */
public class p16_18_PatternMatchingLCCI {

    public boolean patternMatching(String pattern, String value) {

        int countA = 0, countB = 0;

        // 统计pattern中a和b的个数
        for (char c : pattern.toCharArray()) {
            if (c == 'a') {
                countA++;
            } else {
                countB++;
            }
        }

        // 如果a的个数小于b，交换ab
        // 交换后仅枚举a即可
        if (countA < countB) {
            int tmp = countA;
            countA = countB;
            countB = tmp;
            char[] charArray = pattern.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = charArray[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(charArray);
        }

        // countB == 0, 表示pattern仅有a，a = ""即可成立
        if (value.length() == 0) {
            return countB == 0;
        }

        if (pattern.length() == 0) {
            return false;
        }

        for (int lenA = 0; lenA * countA <= value.length(); lenA++) {
            int remain = value.length() - lenA * countA;
            // 仅在b为0或剩余长度可整除b的个数的情况下枚举
            if ((countB == 0 && remain == 0)
                    || (countB != 0 && remain % countB == 0)) {
                int lenB = countB == 0 ? 0 : remain / countB;
                // 位置指针
                int pos = 0;
                boolean correct = true;
                String a = "", b = "";

                for (char c : pattern.toCharArray()) {
                    if (c == 'a') {
                        // 获取当前子串
                        String sub = value.substring(pos, pos + lenA);
                        if (a.length() == 0) {
                            a = sub;
                        } else if (!a.equals(sub)){
                            // a与下一子串不相同，跳出
                            correct = false;
                            break;
                        }
                        // a与下一子串匹配
                        pos += lenA;
                    } else {
                        String sub = value.substring(pos, pos + lenB);
                        if (b.length() == 0) {
                            b = sub;
                        } else if (!b.equals(sub)){
                            correct = false;
                            break;
                        }
                        pos += lenB;
                    }
                }
                // 完全匹配且a与b不相同
                if (correct && !a.equals(b)) {
                    return true;
                }

            }
        }


        return false;

    }

}
