package com.acesoft.leetcode;

import com.acesoft.model.TreeNode;

/*
 *  https://leetcode.com/problems/merge-two-binary-trees
 *
 *  Given two binary trees and imagine that when you put one of them to cover the other, some nodes
 *  of the two trees are overlapped while the others are not.
 *
 *  You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 *  then sum node values up as the new value of the merged node. Otherwise, the NOT null node will
 *  be used as the node of new tree.
 *
 *  Example 1:
 *  Input:
 *      Tree 1                     Tree 2
 *            1                         2
 *           / \                       / \
 *          3   2                     1   3
 *         /                           \   \
 *        5                             4   7
 *  Output:
 *  Merged tree:
 *           3
 *          / \
 *         4   5
 *        / \   \
 *       5   4   7
 *  Note: The merging process must start from the root nodes of both trees.
 */
public class LeetCode617 {

  // Naive solution
  private TreeNode mergeBT(TreeNode t1, TreeNode t2, TreeNode mergedTree) {
    if (t1 == null && t2 == null) {
      return null;
    } else if (t1 == null) {
      mergedTree = new TreeNode(t2.getVal());
    } else if (t2 == null) {
      mergedTree = new TreeNode(t1.getVal());
    } else {
      mergedTree = new TreeNode(t1.getVal() + t2.getVal());
    }
    mergedTree.setLeft(mergeBT(t1 == null ? null : t1.getLeft(),
        t2 == null ? null : t2.getLeft(), mergedTree.getLeft()));
    mergedTree.setRight(mergeBT(t1 == null ? null : t1.getRight(),
        t2 == null ? null : t2.getRight(), mergedTree.getRight()));
    return mergedTree;
  }

  private TreeNode mergeBT1(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    t1.setVal(t1.getVal() + t2.getVal());
    t1.setLeft(mergeBT1(t1.getLeft(), t2.getLeft()));
    t1.setRight(mergeBT1(t1.getRight(), t2.getRight()));
    return t1;
  }

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    mergeBT(t1, t2, null);
    return mergeBT1(t1, t2);
  }
}
