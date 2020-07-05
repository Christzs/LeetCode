package com.leetcode.problem.medium;

import com.leetcode.problem.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given linked list: 1->2->3->4->5, and n = 2
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5
 *
 */

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        List<ListNode> record = new ArrayList<>();
        ListNode node = head;
        ListNode res = null;
        while (node != null) {
            record.add(node);
            node = node.next;
        }
        int removeNodeIndex = record.size() - n;
        if (removeNodeIndex == 0){
            res = head.next;
            head.next = null;
            return res;
        }
        if (removeNodeIndex == record.size() - 1) {
            ListNode pre = record.get(removeNodeIndex - 1);
            pre.next = null;
            return head;
        }
        ListNode next = record.get(removeNodeIndex + 1);
        ListNode pre = record.get(removeNodeIndex - 1);
        pre.next = next;
        record.get(removeNodeIndex).next = null;
        return head;
    }

}
