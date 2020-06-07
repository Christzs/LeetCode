package com.leetcode.problem.hard;

import java.util.*;

/**
 * 126. Word Ladder II
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 */
public class p126_WordLadder2 {

    // 单词到id的映射
    private Map<String, Integer> wordId;

    // id到单词的映射
    private ArrayList<String> idWord;

    // 图的边
    private ArrayList<Integer>[] edges;

    public p126_WordLadder2() {
        this.wordId = new HashMap<>();
        this.idWord = new ArrayList<>();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        int id = 0;
        for (String word : wordList) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, id++);
                idWord.add(word);
            }
        }

        if (!wordId.containsKey(endWord)) {
            return new ArrayList<>();
        }

        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }

        this.edges = new ArrayList[idWord.size()];

        for (int i = 0; i < idWord.size(); i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < idWord.size(); i++) {
            for (int j = i + 1; j < idWord.size(); j++) {
                if (checkIfTransByChangeOneLetter(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        int dest = wordId.get(endWord);
        List<List<String>> res = new ArrayList<>();
        int[] cost = new int[id];
        Arrays.fill(cost, Integer.MAX_VALUE);

        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordId.get(beginWord));
        queue.add(tmpBegin);
        cost[wordId.get(beginWord)] = 0;

        // 广度优先搜索
        while (!queue.isEmpty()) {

            ArrayList<Integer> now  = queue.poll();
            int latest = now.get(now.size() - 1);
            if (latest == dest) {
                ArrayList<String> tmp = new ArrayList<>();
                for (Integer i : now) {
                    tmp.add(idWord.get(i));
                }
                res.add(tmp);
            } else {
                for (int i = 0; i < edges[latest].size(); i++) {
                    int to = edges[latest].get(i);
                    // 符合条件的加入队列
                    if (cost[latest] + 1 <= cost[to]) {
                        cost[to] = cost[latest] + 1;
                        ArrayList<Integer> tmpList = new ArrayList<>(now);
                        tmpList.add(to);
                        queue.add(tmpList);
                    }
                }
            }

        }

        return res;

    }

    private boolean checkIfTransByChangeOneLetter(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length() && diff < 2; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

}
