package com.acesoft.leetcode;

import com.acesoft.model.TreeNode;

/*
 * https://leetcode.com/problems/deepest-leaves-sum
 * 
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 * 
 * Example 1:
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 * 
 * Example 2:
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * 1 <= Node.val <= 100
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class LeetCode1302 {
    private int[] calcDeepestLeavesSum(TreeNode root, int val, int maxDepth) {
        if (root == null) {
            return new int[] { val, maxDepth };
        }
        int[] leftSide = calcDeepestLeavesSum(root.getLeft(), root.getVal(), maxDepth + 1);
        int[] rightSide = calcDeepestLeavesSum(root.getRight(), root.getVal(), maxDepth + 1);
        if (leftSide[1] == rightSide[1]) {
            return new int[] { leftSide[0] + rightSide[0], leftSide[1] };
        } else if (leftSide[1] > rightSide[1]) {
            return leftSide;
        }
        return rightSide;
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root.getRight() == null && root.getLeft() == null) {
            return root.getVal();
        }
        return calcDeepestLeavesSum(root, root.getVal(), 0)[0] / 2;
    }
}