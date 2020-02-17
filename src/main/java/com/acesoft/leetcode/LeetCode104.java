package com.acesoft.leetcode;

import com.acesoft.model.TreeNode;

/*
 *  https://leetcode.com/problems/maximum-depth-of-binary-tree
 *
 *  Given a binary tree, find its maximum depth.
 *
 *  The maximum depth is the number of nodes along the longest path from the root node down to the
 *  farthest leaf node.
 *
 *  Note: A leaf is a node with no children.
 *
 *  Example:
 *
 *  Given binary tree [3,9,20,null,null,15,7],
 *
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 *  return its depth = 3.
 */
public class LeetCode104 {

	public int maxDep(TreeNode root, int count) {
		if (root == null) {
			return 0;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			return count;
		}
		int left = maxDep(root.getLeft(), count + 1);
		int right = maxDep(root.getRight(), count + 1);
		return Math.max(left, right);
	}

	public int maxDepth(TreeNode root) {
		return maxDep(root, 1);
	}
}