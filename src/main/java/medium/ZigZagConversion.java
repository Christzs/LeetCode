package medium;

/**
 * @Description
 *
 * 06 ZigZag Conversion
 *
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * And then read line by line: "PINALSIGYAHRPI"
 *
 * You may assume that the maximum length of s is 1000
 *
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 *
 * Output: "PAHNAPLSIIGYIR"
 *
 */

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (s.equals("") || numRows <= 1) {
            return s;
        }
        int zigNum = numRows - 2, i, j;//之字斜边字符个数
        int length = s.length();
        int addNum = 2 * numRows - 2;//之字竖列字符下标差
        StringBuilder result = new StringBuilder();
        for (i = 0; i < numRows; i++) {
            j = i;
            if (i == 0 || i == numRows - 1) {//上线边界无之字斜边字符
                while (j < length) {
                    result.append(s.charAt(j));
                    j += addNum;
                }
            } else {//获得之字斜边字符
                while (j < length && zigNum >= 0) {
                    result.append(s.charAt(j));
                    if (j + 2 * zigNum < length) {
                        result.append(s.charAt(j + 2 * zigNum));
                    }
                    j += addNum;
                }
                zigNum--;//更新斜边字符获取位置
            }
        }
        return result.toString();
    }

}
