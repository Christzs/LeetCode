package com.leetcode.problem.medium;

import com.leetcode.problem.TreeNode;

/**
 * 337. House Robber III
 *
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 */
public class _337_HouseRobber3 {

    public int rob(TreeNode root) {

        int[] res = robFromTree(root);

        return Math.max(res[0], res[1]);

    }

    private int[] robFromTree(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] res = new int[2];

        // 取子节点res
        int[] left = robFromTree(node.left);
        int[] right = robFromTree(node.right);

        // 状态0表示不偷，取两个子节点偷或不偷的最大值
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 状态1表示偷，取两个子节点不偷的值
        res[1] = left[0] + right[0] + node.val;

        return res;
    }

}
