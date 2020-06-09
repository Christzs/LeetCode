package com.leetcode.problem.interview;

import com.leetcode.problem.TreeNode;

/**
 * @author zst
 * @date 2020-06-09
 */
public class p55_TreeMaxDepth {

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }

}
