package com.leetcode.problem.medium;

import com.leetcode.problem.ListNode;

import java.util.Stack;

/**
 * 61. Rotate List
 *
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 */
public class p61_RotateList {

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        int reverse =  length - k % length, index = 0;

        node = head;
        ListNode newHead = null, newTail = null, newMid = null;
        while (node != null) {
            if (index == reverse - 1) {
                newMid = node;
            }
            if (index == reverse) {
                newHead = node;
            }
            if (node.next == null) {
                newTail = node;
            }
            node = node.next;
            index++;
        }
        newMid.next = null;
        if (newHead == null) {
            return head;
        }
        newTail.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        System.out.println(rotateRight(node1, 2));
    }

}
