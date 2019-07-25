package Easy;

/**
 * @Description
 *
 * 09 Palindrome Number
 *
 *
 * Determine whether an integer is a palindrome
 *
 * An integer is a palindrome when it reads the same backward as forward
 *
 *
 * Input: "121"
 *
 * Output: true
 *
 */

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {

        // x 小于零为非回文数字
        // x 为10的倍数且不为零，为非回文数字
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int res = 0;

        // 翻转数字直至res >= x
        while (x > res) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        // res == x，x为偶数
        // res/10 == x，x为奇数
        return x == res || x == res/10;
    }

}
