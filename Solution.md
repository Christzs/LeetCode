## 01 - Two Sum
- 解法：利用HashMap将查找时间由`O(n)`降至`O(1)`

## 02 - Add Two Numbers
- 解法：遍历链表，注意两数相加的进位问题

## 03 - Longest SubString Without Repeating Characters
 - 解法：滑动窗口判断最长子串，HashMap存储字符下标
 - 遇到重复字符且，窗口左侧滑动至重复字符右侧，但需保证查询得到的下标位于当前窗口内

## 04 - Median of Two Sorted Arrays
- 解法：二分查找，最优思路采取LeetCode推荐解法，详见程序注释

## 05 - Longest Palindromic Substring
- 解法：最长回文串，经典解法 *Manacher算法*

推荐blog：[Manacher算法的详细讲解](https://www.jianshu.com/p/116aa58b7d81)

## 06 - ZigZag Conversion
- 解法：字符串之字形变换，观察规律，按照字符串下标顺序获取字符

## 07 - Reverse Integer
- 解法：翻转整型，通过余数翻转，注意不超过Integer边界值

## 08 - String to Integer
- 解法：字符串转整型，遍历字符串确认符号以及合法性，针对合法整型逐位计算
  
## 09 - Palindrome Number
判断回文数字
- 解法：最优思路采取LeetCode推荐解法，详见程序注释

## 10 - Regular Expression Matching
正则匹配
- 解法：TODO: 待解决，动态规划

## 11 - Container With Most Water
求坐标系两条垂直于x轴的直线所能围成的最大闭合矩形面积

- 解法：指定左右指针从两边依次向中间移动，移动条件为 *移动较短的一边*，直至两指针相遇
- 每次移动后记录面积，`maxArea = maxArea > newArea ? maxArea : newArea`

## 12 - Integer to Roman
十进制转罗马数字

- 解法1：不断的if-else，判断对应罗马数字
- 解法2：列出特殊数字，遍历特殊数字，解法见程序注释

## 13 - Roman to Integer
罗马数字转十进制

规律：
- Roman字符串自右向左遍历，设结果res为Roman最右边数字right
- 如果，右边数字right大于左边数字left，res -= left
- 如果，右边数字right不大于左边数字left，res += left

## 14 - LongestCommonPrefix
若干字符串的公共最长前缀

- 解法：遍历字符串数组，依次两两寻找字符串共有前缀，直至两两字符串不拥有共同前缀或遍历结束

## 15 - 3Sum
数组中不重复的和为0的数字三元组

- 解法：两边指针向中心遍历，跳过重复数字

## 16 - 3Sum Closest
最接近目标数字的三数之和

- 解法：排序数组，从头遍历，通过双指针寻找并计算三数之和

## 17 - Letter Combinations of a Phone Number

- 解法：回溯思想，1字母连接下一组字母的方式相同，利用递归方式，终止条件为连接了所有数字下的字母

## 18 - 4Sum

- 解法：每次循环固定一个数字，变换为三数之和，获得结果后继续遍历，遇到相同数字跳过避免重复

## 20 - Valid Parentheses

- 解法：利用堆栈先入后出的特点，括号匹配则弹出，不匹配返回false，遍历字符串后堆栈为空表示valid

## 21 - Merge Two Sorted Lists

- 解法：设置一个node结点的preHead指针，便于输出结果，重复两个链表的节点比较过程，将合适的节点插入node，当某一链表为空时，简单讲所有链表插入尾端即可