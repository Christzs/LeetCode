package com.leetcode.problem.interview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * example:
 *
 * input: 12258
 * output: 5
 * explain: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class p46_NumberConvertToString {

    private LinkedList<Integer> numList;

    private Queue<Integer> queue;

    public p46_NumberConvertToString() {
        this.numList = new LinkedList<>();
        this.queue = new LinkedList<>();
    }

    public int translateNum(int num) {

        if(num == 0) {
            return 1;
        }
        while (num != 0) {
            numList.addFirst(num%10);
            num /= 10;
        }
        int length = numList.size();

        // 初始化队列
        returnNextIndex(0);

        // 广度优先搜索
        int res = 0, curWidth, curIndex;
        while (!queue.isEmpty()) {
            curWidth = queue.size();
            for (int i = 0; i < curWidth; i++) {
                curIndex = queue.poll();
                if (curIndex == length - 1) {
                    res++;
                } else {
                    returnNextIndex(curIndex + 1);
                }
            }
        }

        return res;
    }

    private void returnNextIndex(int curIndex) {
        queue.offer(curIndex);
        if (curIndex < numList.size() - 1) {
            if (numList.get(curIndex) == 1) {
                queue.offer(curIndex + 1);
            }
            if (numList.get(curIndex) == 2 && numList.get(curIndex + 1) <= 5) {
                queue.offer(curIndex + 1);
            }
        }
    }

}
