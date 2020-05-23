package com.leetcode.problem;

import java.util.ArrayList;

/**
 * @author zst
 * @date 2020-04-29
 */
public class MountainArray {

    private ArrayList<Integer> list;

    public MountainArray() {
        this.list = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
    }

    public Integer get(int index) {
        return list.get(index);
    }
    public int length() {
        return list.size();
    }

}
