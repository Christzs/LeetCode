package com.leetcode.problem.hard;

import com.leetcode.problem.ListNode;

import java.util.Stack;

/**
 * 25. Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list
 *
 * k is a positive integer and is less than or equal to the length of the linked list
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is
 *
 * input:
 * 1->2->3->4->5
 *
 * output:
 * k = 2: 2->1->4->3->5
 * k = 3: 3->2->1->4->5
 *
 * 解法：
 * 每次翻转结构相同，采用递归方式
 * 当不足k个时按照原排序返回，停止递归
 */
public class _25_ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (k == 0 || head == null) {
            return head;
        }

        ListNode start, end;

        start = end = head;

        for (int i = 0; i < k; i++) {
            // 不足k个，返回头部
            if (end == null) {
                return head;
            }
            end = end.next;
        }

        // 从start至end，k个节点，翻转该部分
        ListNode newStart = reverseList(start, end);

        start.next = reverseKGroup(end, k);

        return newStart;

    }

    private ListNode reverseList(ListNode start, ListNode end) {
        ListNode pre, cur, next;
        pre = null;
        cur = start;

        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
