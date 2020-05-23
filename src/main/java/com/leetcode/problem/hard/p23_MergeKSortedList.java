package com.leetcode.problem.hard;

import com.leetcode.problem.ListNode;


/**
 * 23. Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 *
 * 解法：
 *
 * 比较 k 个节点（每个链表的首节点），获得最小值的节点
 * 将选中的节点接在最终有序链表的后面
 */
public class p23_MergeKSortedList {

    public static ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;

        if (len == 0) {
            return null;
        }

        ListNode head = new ListNode(Integer.MAX_VALUE);

        ListNode cur = head;

        while (cur != null) {
            int index = -1;
            ListNode next = head;
            for(int i = 0; i < len; i++) {
                if (lists[i] != null) {
                    if (next.val >= lists[i].val) {
                        next = lists[i];
                        index = i;
                    }
                }
            }
            if (index < 0) {
                break;
            }
            lists[index] = lists[index].next;
            cur.next = next;
            cur = cur.next;
        }
        return head.next;
    }


}
