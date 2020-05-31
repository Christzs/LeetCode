package com.leetcode.problem.easy;

import com.leetcode.problem.TreeNode;

import java.util.*;

/**
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 */
public class p101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    private boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(u);
        queue.offer(v);

        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();

            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }
            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);
        }

        return true;
    }

}
