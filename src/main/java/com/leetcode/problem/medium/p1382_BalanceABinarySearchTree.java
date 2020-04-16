package com.leetcode.problem.medium;

import com.leetcode.problem.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. Balance a Binary Search Tree
 *
 * Given a binary search tree, return a balanced binary search tree with the same node values.
 *
 * A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.
 *
 * If there is more than one answer, return any of them.
 *
 *
 * 解法: 中序遍历构造有序数组，有序数组构造平衡二叉树的代码
 */
public class p1382_BalanceABinarySearchTree {

    public TreeNode balanceBST(TreeNode root) {

        List<Integer> sortList = new ArrayList<>();

        // 中序遍历
        inorder(sortList, root);

        // 有序链表构造平衡二叉树
        return buildTree(sortList, 0, sortList.size() - 1);
    }

    private void inorder(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(list, node.left);
        list.add(node.val);
        inorder(list, node.right);
    }

    private TreeNode buildTree(List<Integer> sortList, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(sortList.get(mid));
        root.left = buildTree(sortList, start, mid - 1);
        root.right = buildTree(sortList, mid + 1, end);
        return root;
    }

}
