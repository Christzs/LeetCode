package easy;

/**
 * @Description
 *
 * 07 Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer
 *
 * Input: 123
 *
 * Output: 321
 *
 */

public class ReverseInteger {

    public static int reverse(int x) {
        int result = 0;
        // 循环获取x的最低位
        while (x != 0) {
            // 获取x的最低位
            int left = x % 10;
            // 判断结果是否超出Integer的最大值 2147483647
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && left > 7)) {
                return 0;
            }
            // 判断结果是否超出Integer的最小值 -2147483648
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && left < -8)) {
                return 0;
            }
            x /= 10;
            result = result * 10 + left;
        }
        return result;
    }
}
