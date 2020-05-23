package com.leetcode.problem;

/**
 * @author zst
 * @date 2020-01-27
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next.val +
                '}';
    }
}
