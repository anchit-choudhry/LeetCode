package com.acesoft.leetcode;

import com.acesoft.model.TreeNode;

/*
 *  https://leetcode.com/problems/maximum-binary-tree
 *
 *  Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 *  The root is the maximum number in the array.
 *  The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 *  The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 *  Construct the maximum tree by the given array and output the root node of this tree.
 *
 *  Example 1:
 *  Input: [3, 2, 1, 6, 0, 5]
 *  Output: return the tree root node representing the following tree:
 *        6
 *      /   \
 *     3     5
 *      \    /
 *       2  0
 *         \
 *          1
 *
 *  Note:
 *  The size of the given array will be in the range [1, 1000].
 */
public class LeetCode654 {

  // Naive solution using recursion
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return returnMaxBinTree(nums, 0, nums.length, null);
  }

  private TreeNode returnMaxBinTree(int[] nums, int start, int stop, TreeNode root) {
    int i, maxIndex = -1, temp = -1;
    for (i = start; i < stop; i++) {
      if (temp < nums[i]) {
        maxIndex = i;
        temp = nums[i];
      }
    }
    if (root == null && maxIndex > -1) {
      root = new TreeNode(nums[maxIndex]);
    }
    if (start < maxIndex) {
      root.setLeft(returnMaxBinTree(nums, start, maxIndex, root.getLeft()));
    }
    if (maxIndex + 1 < stop) {
      root.setRight(returnMaxBinTree(nums, maxIndex + 1, stop, root.getRight()));
    }
    return root;
  }
}
