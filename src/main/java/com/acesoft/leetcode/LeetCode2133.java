package com.acesoft.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers
 *
 * An n x n matrix is valid if every row and every column contains all the integers from 1 to n
 * (inclusive).
 *
 * Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return
 * false.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
 * Output: true
 * Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
 * Hence, we return true.
 *
 * Example 2:
 * Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
 * Output: false
 * Explanation: In this case, n = 3, but the first row and the first column do not contain the
 * numbers 2 or 3.
 * Hence, we return false.
 *
 * Constraints:
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * 1 <= matrix[i][j] <= n
 */
public class LeetCode2133 {

  public boolean checkValid(int[][] matrix) {
    int i, j, len = matrix[0].length;
    int[] rowSet = new int[101];
    int[] colSet = new int[101];
    for (i = 0; i < len; i++) {
      Arrays.fill(rowSet, 0);
      Arrays.fill(colSet, 0);
      for (j = 0; j < len; j++) {
        if (rowSet[matrix[i][j]] != 0 || colSet[matrix[j][i]] != 0) {
          return false;
        }
        rowSet[matrix[i][j]]++;
        colSet[matrix[j][i]]++;
      }
    }
    return true;
  }
}
