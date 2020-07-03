package com.leetcode.problem.easy;

import com.leetcode.problem.TreeNode;

/**
 * @author zst
 * @date 2020-07-03
 */
public class p108_ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        TreeNode node = null;
        if (left <= right) {
            int mid = left + ((right - left) >> 1);
            node = new TreeNode(nums[mid]);
            node.left = buildTree(nums, left, mid - 1);
            node.right = buildTree(nums, mid + 1, right);
        }
        return node;
    }

}
