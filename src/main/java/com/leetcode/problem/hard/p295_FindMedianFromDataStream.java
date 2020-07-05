package com.leetcode.problem.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
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
