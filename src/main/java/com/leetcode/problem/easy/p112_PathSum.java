package com.leetcode.problem.easy;

import com.leetcode.problem.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. Path Sum
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 */
public class p112_PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        queueNode.offer(root);
        queueVal.offer(root.val);
        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int tmp = queueVal.poll();
            if (node.left == null && node.right == null) {
                if (sum == tmp) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                queueNode.offer(node.left);
                queueVal.offer(tmp + node.left.val);
            }
            if (node.right != null) {
                queueNode.offer(node.right);
                queueVal.offer(tmp + node.right.val);
            }
        }
        return false;
    }

}
