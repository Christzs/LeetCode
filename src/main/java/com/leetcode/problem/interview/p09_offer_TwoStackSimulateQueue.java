package com.leetcode.problem.interview;

import java.util.Stack;

/**
 * @author zst
 * @date 2020-06-30
 */
public class p09_offer_TwoStackSimulateQueue {

    private Stack<Integer> stack;

    private Stack<Integer> assist;

    public p09_offer_TwoStackSimulateQueue() {
        this.stack = new Stack<>();
        this.assist = new Stack<>();
    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if (stack.isEmpty() && assist.isEmpty()) {
            return -1;
        }
        if (!assist.isEmpty()) {
            return assist.pop();
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            assist.push(stack.pop());
        }
        return assist.pop();
    }

}
