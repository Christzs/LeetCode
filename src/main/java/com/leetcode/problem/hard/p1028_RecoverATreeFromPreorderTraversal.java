package com.leetcode.problem.hard;

import com.leetcode.problem.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1028. Recover a Tree From Preorder Traversal
 * We run a preorder depth first search on the root of a binary tree.
 *
 * At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.
 * (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)
 *
 * If a node has only one child, that child is guaranteed to be the left child.
 *
 * Given the output S of this traversal, recover the tree and return its root.
 *
 *
 *
 * Example 1:
 * Input: "1-2--3--4-5--6--7"
 * Output: [1,2,5,3,4,6,7]
 */
public class p1028_RecoverATreeFromPreorderTraversal {

    public TreeNode recoverFromPreorder(String S) {

        Deque<TreeNode> path = new LinkedList<>();
        int pos = 0;
        while (pos < S.length()) {
            // 根据 - 获取树的深度
            int level = 0;
            while (S.charAt(pos) == '-') {
                level++;
                pos++;
            }
            // 获取节点数值
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + (S.charAt(pos) - '0');
                pos++;
            }
            TreeNode node = new TreeNode(value);
            // 如果当前深度与path相等，则该节点为上一节点的左子节点
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            }
            // 如果当前深度与path不等，则需返回该深度对应节点位置
            else {
                while (level != path.size()) {
                    path.poll();
                }
                // node节点为右节点
                path.peek().right = node;
            }
            // node节点加入当前path
            path.push(node);
        }

        // 返回根节点
        return path.getFirst();

    }

}
