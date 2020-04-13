package com.leetcode.problem.hard;

import java.util.*;

/**
 * 460. LFU Cache
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item.
 * For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
 *
 *
 */
public class p460_LFUCache {

    class LFUCache {

        /**
         * key为传入的key，value为节点内容
         */
        private Map<Integer, ListNode> keyMap;

        /**
         * key为频率，value为双向链表，链表采用头插法，表头表示最近插入的内容，链表尾部表示最早插入的内容
         */
        private Map<Integer, DoubleLinkedList> frequentMap;

        private Integer capacity;

        /**
         * 最大访问频率，用于寻找最小访问评率，可优化为最小访问频率
         */
        private Integer maxFrequent = 1;

        public LFUCache(Integer capacity) {
            keyMap = new HashMap<>(capacity);
            frequentMap = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            if (!keyMap.containsKey(key)) {
                return -1;
            }
            // 从当前频率链表中移除
            ListNode node = removeListNode(key);
            int frequent = node.frequent;
            // 插入下一频率的链表
            addListNode2Head(frequent, node);
            return node.value;
        }

        public void put(int key, int value) {
            if (keyMap.containsKey(key)) {
                ListNode node = removeListNode(key);
                node.value = value;
                int frequent = node.frequent;
                addListNode2Head(frequent, node);
                return;
            }
            if (keyMap.size() == capacity) {
                for (int i = 0; i <= maxFrequent; i++) {
                    if (frequentMap.containsKey(i) && frequentMap.get(i).length > 0) {
                        // 移除频率尾部节点，即同一频率下最早插入的节点
                        ListNode node = frequentMap.get(i).removeTail();
                        keyMap.remove(node.key);
                        break;
                    }
                }
            }
            ListNode newNode = new ListNode(key, value);
            // 新加入节点插入频率为1的链表中
            addListNode2Head(1, newNode);
            keyMap.put(key, newNode);
        }

        /**
         * 移除列表中的某个节点
         * @param key
         * @return
         */
        private ListNode removeListNode(int key) {
            ListNode node = keyMap.get(key);
            ListNode pre = node.pre;
            ListNode next = node.next;
            pre.next = next;
            next.pre = pre;
            node.next = null;
            node.pre = null;

            frequentMap.get(node.frequent).length--;
            node.frequent++;

            maxFrequent = Math.max(node.frequent, maxFrequent);

            return node;
        }

        /**
         * 将节点插入频次统计链表的头部
         * @param frequent
         * @param node
         */
        private void addListNode2Head(int frequent, ListNode node) {
            if (!frequentMap.containsKey(frequent)) {
                frequentMap.put(frequent, new DoubleLinkedList());
            }
            frequentMap.get(frequent).addNode2Head(node);
        }

        private class ListNode {
            private int key;
            private int value;
            private int frequent = 1;
            private ListNode pre;
            private ListNode next;

            public ListNode() {
            }

            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return "ListNode{" +
                        "key=" + key +
                        ", value=" + value +
                        ", frequent=" + frequent +
                        '}';
            }
        }

        private class DoubleLinkedList {
            private ListNode head;
            private ListNode tail;
            private int length;

            public DoubleLinkedList() {
                this.head = new ListNode(-1, -1);
                this.tail = new ListNode(-1, -1);
                head.next = tail;
                tail.pre = head;
                length = 0;
            }

            public void addNode2Head(ListNode node) {
                ListNode headNext = head.next;
                head.next = node;
                node.pre = head;
                node.next = headNext;
                headNext.pre = node;
                length++;
            }

            public ListNode removeTail() {
                ListNode realTail = tail.pre;
                ListNode nextTail = realTail.pre;

                nextTail.next = tail;
                tail.pre = nextTail;

                realTail.next = null;
                realTail.pre = null;
                length--;
                return realTail;
            }
        }

    }

    public static void main(String[] args) {
        LFUCache lfuCache = new p460_LFUCache().new LFUCache(2);

        lfuCache.get(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.get(1);
        lfuCache.put(3, 3);
        lfuCache.get(2);
        lfuCache.get(3);
        lfuCache.put(4, 4);
        lfuCache.get(1);
        lfuCache.get(3);
        lfuCache.get(4);
    }

}
