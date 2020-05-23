package com.leetcode.problem.medium;

import java.util.*;

/**
 * 355. Design Twitter
 *
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed.
 * Your design should support the following methods:
 *
 * 1. postTweet(userId, tweetId): Compose a new tweet.
 * 2. getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 *    Each item in the news feed must be posted by users who the user followed or by the user herself.
 *    Tweets must be ordered from most recent to least recent.
 * 3. follow(followerId, followeeId): Follower follows a followee.
 * 4. unfollow(followerId, followeeId): Follower unfollows a followee.
 *
 */
public class p355_DesignTwitter {

    /**
     * Your Twitter object will be instantiated and called as such:
     * Twitter obj = new Twitter();
     * obj.postTweet(userId,tweetId);
     * List<Integer> param_2 = obj.getNewsFeed(userId);
     * obj.follow(followerId,followeeId);
     * obj.unfollow(followerId,followeeId);
     */

    class Twitter {

        private HashMap<Integer, Feed> userFeeds;

        private HashMap<Integer, Set<Integer>> userFollows;

        private int timestamp = 0;

        /** Initialize your data structure here. */
        public Twitter() {
            this.userFeeds = new HashMap<>();
            this.userFollows = new HashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            Feed oldHead = userFeeds.get(userId);
            userFeeds.compute(userId, (k, v) -> new Feed(tweetId, ++timestamp)).next = oldHead;
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed.
         * Each item in the news feed must be posted by users who the user followed or by the user herself.
         * Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Feed> queue = new PriorityQueue<>((f1, f2) -> f2.created - f1.created);
            List<Integer> feeds = new ArrayList<>(10);
            Set<Integer> searchIds = new HashSet<>();
            searchIds.add(userId);
            if (userFollows.containsKey(userId)) {
                searchIds.addAll(userFollows.get(userId));
            }
            for (Integer id : searchIds) {
                if (userFeeds.get(id) != null) {
                    queue.offer(userFeeds.get(id));
                }
            }
            int count = 0;
            while (!queue.isEmpty() && count < 10) {
                Feed feed = queue.poll();
                feeds.add(feed.getId());
                if (feed.next != null) {
                    queue.offer(feed.next);
                }
                count++;
            }
            return feeds;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (!userFollows.containsKey(followerId)) {
                userFollows.put(followerId, new HashSet<>());
            }
            userFollows.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (userFollows.containsKey(followerId)) {
                userFollows.get(followerId).remove(followeeId);
            }
        }

        class Feed {
            private Integer id;
            private Integer created;
            private Feed next;

            public Feed(Integer id, Integer created) {
                this.id = id;
                this.created = created;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getCreated() {
                return created;
            }

            public void setCreated(Integer created) {
                this.created = created;
            }

            public Feed getNext() {
                return next;
            }

            public void setNext(Feed next) {
                this.next = next;
            }
        }
    }





}
