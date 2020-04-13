package com.leetcode.problem.medium;

import com.leetcode.problem.ListNode;

/**
 * 24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head
 *
 * Input:
 *  1->2->3->4
 * Output:
 *  2->1->4->3
 *
 *  解法：
 *
 *  - 从链表的头节点 head 开始递归。
 *  - 每次递归都负责交换一对节点
 *  - 下一次递归则是传递的是下一对需要交换的节点。若链表中还有节点，则继续递归
 *  - 终止条件为传入的节点为空(偶数), 或者传入节点的下一个节点为空(奇数)
 *
 */
public class _24_SwapNodesINPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

}
