package com.leetcode.problem.interview;

import com.leetcode.problem.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. Remove Duplicate Node LCCI
 * Write code to remove duplicates from an unsorted linked list.
 *
 * Example1:
 *
 *  Input: [1, 2, 3, 3, 2, 1]
 *  Output: [1, 2, 3]
 */
public class p02_01_RemoveDuplicateNodeLCCI {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> nodeValSet = new HashSet<>();
        nodeValSet.add(head.val);
        ListNode next = null, cur = head;
        while (cur.next != null) {
            next = cur.next;
            // 当前节点值与前一节点值相等，删除该节点
            if (nodeValSet.add(next.val)) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        cur.next = null;
        return head;
    }

}
