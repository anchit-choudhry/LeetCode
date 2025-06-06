package com.acesoft.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/validate-binary-tree-nodes
 *
 * You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i]
 * and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.
 *
 * If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
 *
 * Note that the nodes have no values and that we only use the node numbers in this problem.
 *
 * Example 1:
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * Output: true
 *
 * Example 2:
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * Output: false
 *
 * Example 3:
 * Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
 * Output: false
 *
 * Example 4:
 * Input: n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
 * Output: false
 *
 * Constraints:
 * 1 <= n <= 10^4
 * leftChild.length == rightChild.length == n
 * -1 <= leftChild[i], rightChild[i] <= n - 1
 */
public class LeetCode1361 {

  // Suboptimal solution
  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    if (n == 1 && leftChild[0] - rightChild[0] == 0) {
      return false;
    }
    int i;
    Set<Integer> hs = new HashSet<>();
    for (i = 0; i < n; i++) {
      if (leftChild[i] != -1) {
        if (i >= leftChild[i] || hs.contains(leftChild[i])) {
          return false;
        } else {
          hs.add(leftChild[i]);
        }
      }
      if (rightChild[i] != -1) {
        if (i >= rightChild[i] || hs.contains(rightChild[i])) {
          return false;
        } else {
          hs.add(rightChild[i]);
        }
      }
    }
    return hs.size() == n - 1;
  }
}