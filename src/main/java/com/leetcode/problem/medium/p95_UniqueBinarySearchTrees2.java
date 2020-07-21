package com.leetcode.problem.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class p95_UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return buildTree(1, n);
    }

    private List<TreeNode> buildTree(int start, int end) {
        List<TreeNode> tree = new ArrayList<>();
        if (start > end) {
            tree.add(null);
            return tree;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = buildTree(start, i - 1);
            List<TreeNode> rightTree = buildTree(i + 1, end);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    tree.add(root);
                }
            }
        }
        return tree;
    }

}
