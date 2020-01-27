package com.leetcode.problem.easy;


import com.leetcode.problem.assist.ListNode;

/**
 * 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list
 *
 * The new list should be made by splicing together the nodes of the first two lists
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 *
 * 解法：
 *
 * 设置一个node结点的preHead指针，便于输出结果，重复两个链表的节点比较过程
 *
 * 将合适的节点插入node，当某一链表为空时，简单讲所有链表插入尾端即可
 */

public class _21_MergeTwoSortedLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergeHead = new ListNode(-1);
        ListNode mergeNode = mergeHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                mergeNode.next = l1;
                l1 = l1.next;
            } else {
                mergeNode.next = l2;
                l2 = l2.next;
            }
            mergeNode = mergeNode.next;
        }
        mergeNode.next = l1 != null ? l1 : l2;
        return mergeHead.next;
    }

}
