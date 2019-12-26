package easy;

import java.util.*;

/**
 *
 * 12 Roman to Integer
 *
 * Given a roman numeral, convert it to an integer
 *
 * Input is guaranteed to be within the range from 1 to 3999.
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
 * Input:   III   IV    IX    LVIII    MCMXCIV
 *
 * Output:   3     4     9     58       1994
 *
 */


public class Roamn2Integer {

    private static final Map<String, Integer> ROMANS_TO_NUMS = new HashMap<String, Integer>();

    static {
        ROMANS_TO_NUMS.put("I", 1);
        ROMANS_TO_NUMS.put("V", 5);
        ROMANS_TO_NUMS.put("X", 10);
        ROMANS_TO_NUMS.put("L", 50);
        ROMANS_TO_NUMS.put("C", 100);
        ROMANS_TO_NUMS.put("D", 500);
        ROMANS_TO_NUMS.put("M", 1000);
    }

    public static int romanToInt(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int res = ROMANS_TO_NUMS.get(String.valueOf(cs[len - 1]));
        int right = res;
        try {
            for (int index = len - 2; index >= 0; index--) {
                int left = ROMANS_TO_NUMS.get(String.valueOf(cs[index]));
                if (right > left) {
                    res -= left;
                } else {
                    res += left;
                }
                right = left;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("string 's' have illegal character");
        }
        return res;
    }

}
