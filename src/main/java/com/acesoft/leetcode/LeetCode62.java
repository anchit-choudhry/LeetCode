package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/unique-paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Example 1:
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Example 2:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 * Example 3:
 * Input: m = 7, n = 3
 * Output: 28
 *
 * Example 4:
 * Input: m = 3, n = 3
 * Output: 6
 *
 * Constraints:
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 109.
 */
public class LeetCode62 {

  private int[][] cache;

  private int isValidUniquePath(int m, int n) {
    if (m < 0 || n < 0) {
      return 0;
    }
    if (m == 0 && n == 0) {
      return 1;
    }
    if (cache[m][n] > 0) {
      return cache[m][n];
    }
    cache[m][n] = isValidUniquePath(m - 1, n) + isValidUniquePath(m, n - 1);
    return cache[m][n];
  }

  public int uniquePaths(int m, int n) {
    cache = new int[m][n];
    return isValidUniquePath(m - 1, n - 1);
  }
}