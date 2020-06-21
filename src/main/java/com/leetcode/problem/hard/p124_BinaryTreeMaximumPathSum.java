package com.leetcode.problem.hard;

import com.leetcode.problem.TreeNode;

import java.util.Map;

/**
 * 124. Binary Tree Maximum Path Sum
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem,
 * a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * Example:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 */
public class p124_BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxSum(root);
        return maxSum;
    }

    public int getMaxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归计算子节点最大贡献值
        // 贡献值不大于0，贡献值为0
        int leftGain = Math.max(getMaxSum(node.left), 0);
        int rightGain = Math.max(getMaxSum(node.right), 0);

        // 计算当前路径和
        int curPathSum = leftGain + node.val + rightGain;

        // 更新最大路径和
        maxSum = Math.max(curPathSum, maxSum);

        // 返回当前的节点最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }

}
