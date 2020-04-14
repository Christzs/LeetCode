package com.leetcode.problem.medium;

import com.leetcode.problem.ListNode;

import java.util.Stack;

/**
 * 445. Add Two Numbers II
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class p445_AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 == 0 || len2 == 0) {
            return len1 == 0 ? l2 : l1;
        }

        Stack<Integer> sumStack = new Stack<>();

        // 这里复杂化了，可以直接将两条链表分别放入栈中
        while (len1 !=0 && len2 != 0) {
            if (len1 > len2) {
                sumStack.push(l1.val);
                l1 = l1.next;
                len1--;
                continue;
            }
            if (len1 < len2) {
                sumStack.push(l2.val);
                l2 = l2.next;
                len2--;
                continue;
            }
            sumStack.push(l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
            len1--;
            len2--;
        }

        ListNode cur = null, head = null;
        int units = 0, tens = 0;
        while (!sumStack.empty()) {
            int sum = sumStack.pop();
            if (tens != 0) {
                sum += tens;
            }
            units = sum % 10;
            tens = sum / 10;
            head = new ListNode(units);
            head.next = cur;
            cur = head;
        }
        if (tens != 0) {
            head = new ListNode(tens);
            head.next = cur;
        }
        return head;
    }

    private int length(ListNode l) {
        int len = 0;
        while (l != null) {
            l = l.next;
            len++;
        }
        return len;
    }
}
