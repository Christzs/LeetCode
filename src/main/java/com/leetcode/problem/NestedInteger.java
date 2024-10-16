package com.leetcode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @date 2022-04-15 19:43
 */
public class NestedInteger {

    private Integer val;

    private List<NestedInteger> list;

    // Constructor initializes an empty nested list.
    public NestedInteger() {

    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this.val = value;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        if (list == null && val != null) {
            return true;
        }
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        if (list == null && val != null) {
            return val;
        }
        return null;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        this.val = value;
    };

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        if (val == null) {
            return list;
        }
        return Collections.emptyList();
    }

}
