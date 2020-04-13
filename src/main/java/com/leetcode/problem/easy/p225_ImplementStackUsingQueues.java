package com.leetcode.problem.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 225. Implement Stack using Queues
 *
 *
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 */
public class p225_ImplementStackUsingQueues {

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

    class MyStack {

        private List<Integer> stack;


        /** Initialize your data structure here. */
        public MyStack() {
            this.stack = new ArrayList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            stack.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (empty()) {
                throw new NullPointerException();
            }

            return stack.remove(stack.size() - 1);
        }

        /** Get the top element. */
        public int top() {
            if (empty()) {
                throw new NullPointerException();
            }
            return stack.get(stack.size() - 1);
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }

}
