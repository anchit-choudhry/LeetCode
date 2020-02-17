package com.acesoft.model;

/*
 *  Definition for a binary tree node.
 *
 *  public class TreeNode {
 *      int val;
 *      TreeNode left;
 *      TreeNode right;
 *      TreeNode(int x) { val = x; }
 *  }
 */
public class TreeNode {

    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int x) {
        val = x;
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