package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/transpose-matrix
 *
 *  Given a matrix A, return the transpose of A.
 *
 *  The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and
 *  column indices of the matrix.
 *
 *  Example 1:
 *  Input: [[1,2,3],[4,5,6],[7,8,9]]
 *  Output: [[1,4,7],[2,5,8],[3,6,9]]
 *
 *  Example 2:
 *  Input: [[1,2,3],[4,5,6]]
 *  Output: [[1,4],[2,5],[3,6]]
 *
 *  Note:
 *  1 <= A.length <= 1000
 *  1 <= A[0].length <= 1000
 */
public class LeetCode867 {

    public int[][] transpose(int[][] A) {
        int rows = A.length, cols = A[0].length;
        if (cols < 1) {
            return new int[][] {};
        }
        int[][] b = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                b[j][i] = A[i][j];
            }
        }
        return b;
    }
}