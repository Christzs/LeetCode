package com.leetcode.problem.easy;

import com.leetcode.problem.ListNode;

/**
 * @author zst
 * @date 2020-04-09
 */
public class p1290_ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }
        return res;
    }
}
