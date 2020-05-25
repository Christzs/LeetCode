package com.leetcode.problem.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 146. LRU Cache
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 */
public class p146_LruCache {

    class LRUCache {

        private HashMap<Integer, Integer> cacheMap;

        private LinkedList<Integer> cachePriority;

        private Integer capacity;

        public LRUCache(int capacity) {
            this.cacheMap = new HashMap<>(capacity);
            this.cachePriority = new LinkedList<>();
            this.capacity = capacity;
        }

        public int get(Integer key) {
            if (cacheMap.containsKey(key)) {
                cachePriority.remove(key);
                cachePriority.addFirst(key);
                return cacheMap.get(key);
            }
            return -1;
        }

        public void put(Integer key, Integer value) {
            if (cacheMap.containsKey(key)) {
                cachePriority.remove(key);
            } else if (cachePriority.size() >= capacity) {
                cacheMap.remove(cachePriority.removeLast());
            }
            cacheMap.put(key, value);
            cachePriority.addFirst(key);
        }
    }


}
