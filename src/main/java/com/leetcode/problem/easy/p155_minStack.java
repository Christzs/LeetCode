package com.leetcode.problem.easy;

import java.util.LinkedList;

/**
 * 155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class p155_minStack {

    class MinStack {

        private LinkedList<Integer> linkedList;

        private int min;

        /** initialize your data structure here. */
        public MinStack() {
            this.linkedList = new LinkedList<>();
            this.min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            this.linkedList.addLast(x);
            if (x < min) {
                this.min = x;
            }
        }

        public void pop() {
            if (linkedList.size() != 0) {
                int remove = this.linkedList.removeLast();
                if (remove == this.min) {
                    int tmp = Integer.MAX_VALUE;
                    for (int i : linkedList) {
                        tmp = Math.min(i, tmp);
                    }
                    this.min = tmp;
                }
            }
        }

        public int top() {
            if (linkedList.size() != 0) {
                return this.linkedList.getLast();
            }
            return Integer.MIN_VALUE;
        }

        public int getMin() {
            return this.min;
        }
    }
}
