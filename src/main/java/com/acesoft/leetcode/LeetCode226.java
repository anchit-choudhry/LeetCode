package com.acesoft.leetcode;

import com.acesoft.model.TreeNode;

/*
 *  https://leetcode.com/problems/invert-binary-tree  
 *
 *  Invert a binary tree.
 *
 *  Example:
 *
 *  Input:
 *
 *       4
 *     /   \
 *    2     7
 *   / \   / \
 *  1   3 6   9
 *  Output:
 *
 *       4
 *     /   \
 *    7     2
 *   / \   / \
 *  9   6 3   1
 */
public class LeetCode226 {

    // Optimal solution
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.getLeft());
        TreeNode right = invertTree(root.getRight());
        root.setLeft(right);
        root.setRight(left);
        return root;
        /*
         * Subtoptimal solution call return root == null ? null :
         * swapTreeNodes(root.getVal(), root.getLeft(), root.getRight());
         */
    }

    // Suboptimal solution
    private TreeNode swapTreeNodes(int v, TreeNode left, TreeNode right) {
        return new TreeNode(v, right == null ? null : swapTreeNodes(right.getVal(), right.getLeft(), right.getRight()),
                left == null ? null : swapTreeNodes(left.getVal(), left.getLeft(), left.getRight()));
    }
}