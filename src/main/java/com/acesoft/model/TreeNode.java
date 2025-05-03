package com.acesoft.model;

/*
 * Definition for a binary tree node.
 *
 * public class TreeNode {
 *
 *    int val;
 *
 *    TreeNode left;
 *
 *    TreeNode right;
 *
 *    TreeNode() {}
 *
 *    TreeNode(int val) {
 *        this.val = val;
 *    }
 *
 *    TreeNode(int val, TreeNode left, TreeNode right) {
 *        this.val = val;
 *        this.left = left;
 *        this.right = right;
 *    }
 * }
 */
public class TreeNode {

  TreeNode left;
  TreeNode right;
  int val;

  public TreeNode(int x) {
    val = x;
  }

  public TreeNode(int x, TreeNode leftT, TreeNode rightT) {
    val = x;
    left = leftT;
    right = rightT;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  public int getVal() {
    return val;
  }

  public void setVal(int x) {
    val = x;
  }
}
