package com.leetcode.problem.hard;

import com.leetcode.problem.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. Serialize and Deserialize Binary Tree
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 */
public class p297_SerializeAndDeserializeBinaryTree {

    private static final String JOIN = ",";

    private static final String NONE = "null";

    private String dfsSerialize(TreeNode root, String s) {
        if (root == null) {
            s += NONE + JOIN;
        } else {
            s += root.val + JOIN;
            s = dfsSerialize(root.left, s);
            s = dfsSerialize(root.right, s);
        }
        return s;

    }



    /**
     * Encodes a tree to a single string.
     */
    public String serialize(TreeNode root) {
        return dfsSerialize(root, "");
    }

    private TreeNode dfsDeserialize(List<String> nodes) {
        if (nodes.get(0).equals(NONE)) {
            nodes.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes.get(0)));
        nodes.remove(0);
        root.left = dfsDeserialize(nodes);
        root.right = dfsDeserialize(nodes);
        return root;
    }

    /**
     * Decodes your encoded data to tree.
     */
    public TreeNode deserialize(String data) {
        if (null == data || "".equals(data)) {
            return null;
        }
        String[] nodesStr = data.split(JOIN);
        List<String> nodes = new LinkedList<>(Arrays.asList(nodesStr));
        return dfsDeserialize(nodes);

    }

}
