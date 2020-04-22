package com.leetcode.problem.medium;

import com.leetcode.problem.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 解法: 广度优先遍历，取最右侧节点
 */
public class p199_BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        ArrayDeque<TreeNode> seekQueue = new ArrayDeque<>();
        seekQueue.offer(root);

        while (!seekQueue.isEmpty()) {
            res.add(seekQueue.peekLast().val);
            int curSize = seekQueue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = seekQueue.pollFirst();
                if (node.left != null) {
                    seekQueue.offer(node.left);
                }
                if (node.right != null) {
                    seekQueue.offer(node.right);
                }
            }
        }
        seekQueue.clear();

        return res;
    }

}
