package com.leetcode.problem.interview;

import com.leetcode.problem.TreeNode;

/**
 * @author zst
 * @date 2020-06-09
 */
public class p04_04_TreeIsBalanced {

    public boolean isBalanced(TreeNode root) {

        return dfs(root);

    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        return dfs(root.left) && dfs(root.right);
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

}
