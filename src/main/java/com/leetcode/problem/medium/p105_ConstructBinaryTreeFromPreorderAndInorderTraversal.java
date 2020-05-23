package com.leetcode.problem.medium;

import com.leetcode.problem.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class p105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return getCompleteTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode getCompleteTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {

        if (preLeft > preRight) {
            return null;
        }

        // 确定根节点
        int preRootIndex = preLeft;
        int inRootIndex = indexMap.get(preorder[preLeft]);
        TreeNode root = new TreeNode(preorder[preLeft]);

        // 确定左子树
        int leftTreeSize = inRootIndex - inLeft;
        TreeNode left = getCompleteTree(preorder, inorder, preLeft + 1, preLeft + leftTreeSize, inLeft, inRootIndex - 1);
        root.left = left;

        // 确定右子树
        TreeNode right = getCompleteTree(preorder, inorder, preLeft + leftTreeSize + 1, preRight, inRootIndex + 1, inRight);
        root.right = right;

        return root;

    }

}
