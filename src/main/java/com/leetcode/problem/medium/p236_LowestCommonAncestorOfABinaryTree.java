package com.leetcode.problem.medium;

import com.leetcode.problem.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zst
 * @date 2020-05-10
 */
public class p236_LowestCommonAncestorOfABinaryTree {

    private Map<Integer, TreeNode> parents = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parents.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parents.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parents.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parents.put(root.right.val, root);
            dfs(root.right);
        }
    }

}
