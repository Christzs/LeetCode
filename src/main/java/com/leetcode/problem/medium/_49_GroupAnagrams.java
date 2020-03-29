package com.leetcode.problem.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. Group Anagrams
 *
 * Given an array of strings, group anagrams together
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 *
 */
public class _49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();

        if (strs.length == 0) {
            return res;
        }

        Map<String, List<String>> sortedGroupMap = new HashMap<>();

        for (String s : strs) {

            char[] cs = s.toCharArray();
            Arrays.sort(cs);

            String sortedString = String.valueOf(cs);

            if (!sortedGroupMap.containsKey(sortedString)) {
                sortedGroupMap.put(sortedString, new ArrayList<>());
            }
            sortedGroupMap.get(sortedString).add(s);

        }

        res = sortedGroupMap.values().stream().collect(Collectors.toList());

        return res;

    }

}
