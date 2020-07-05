package com.leetcode.problem.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author zst
 * @date 2020-07-05
 */
public class p295_FindMedianFromDataStream {

    static class MedianFinder {

        private PriorityQueue<Integer> minHeap;

        private PriorityQueue<Integer> maxHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            this.minHeap = new PriorityQueue<>();
            this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            if (minHeap.isEmpty() || minHeap.peek() < num) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }

            if (minHeap.size() - maxHeap.size() > 1) {
                int min = minHeap.poll();
                maxHeap.offer(min);
            }
            if (maxHeap.size() - minHeap.size() > 1){
                int max = maxHeap.poll();
                minHeap.offer(max);
            }

        }

        public double findMedian() {
            if (maxHeap.size() == 0 && minHeap.size() == 0) {
                return 0;
            }
            if (maxHeap.size() != minHeap.size()) {
                return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
            } else {
                return (double) (maxHeap.peek() + minHeap.peek()) / 2;
            }
        }
    }

}
