package medium;

/**
 * @Description
 *
 * 08 String to Integer (atoi)
 *
 *
 * Implement atoi which converts a string to an integer
 *
 *
 * Input: "42"
 *
 * Output: 42
 *
 */

public class String2Integer {

    public int myAtoi(String str) {
        boolean positive = true;
        char c;
        int len = str.length(), pos = -1;
        long res = 0;
        for (int i = 0; i < len; i++) {
            c = str.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '-') {
                positive = false;
                pos = i;
                break;
            } else if (c == '+') {
                pos = i;
                break;
            } else if (Character.isDigit(c)) {
                pos = i - 1;
                break;
            } else {
                return (int)res;
            }
        }
        for (int i = pos + 1; i < len; i++) {
            c = str.charAt(i);
            if (Character.isDigit(c)) {
                res = res * 10 + Character.getNumericValue(c);
                if (res > Integer.MAX_VALUE) {
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        return positive ? (int)res : (int)-res;
    }
}
