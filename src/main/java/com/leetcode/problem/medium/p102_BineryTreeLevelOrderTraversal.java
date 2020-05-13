package com.leetcode.problem.medium;

import com.leetcode.problem.TreeNode;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class p102_BineryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        ArrayDeque<TreeNode> treeQueue = new ArrayDeque<>();

        treeQueue.offer(root);

        List<List<Integer>> res = new ArrayList<>();

        while (!treeQueue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = treeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = treeQueue.poll();
                tmp.add(cur.val);
                if (cur.left != null) {
                    treeQueue.add(cur.left);
                }
                if (cur.right != null) {
                    treeQueue.add(cur.right);
                }
            }
            res.add(tmp);
        }

        return res;

    }

}
