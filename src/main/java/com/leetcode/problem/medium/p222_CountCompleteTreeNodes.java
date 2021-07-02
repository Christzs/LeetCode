package com.leetcode.problem.medium;

import com.leetcode.problem.TreeNode;

/**
 * @author tianzhongshi
 * @date 2021-07-02 19:55
 */
public class p222_CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 深度优先搜索
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }
}
