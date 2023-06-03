package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/unique-paths-ii
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 * Example 1:
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * Example 2:
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 *
 * Constraints:
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 */
public class LeetCode63 {

  private int[][] cache;

  private int checkValidPath(int m, int n) {
    if (m < 0 || n < 0 || cache[m][n] == Integer.MIN_VALUE) {
      return 0;
    }
    if (m == 0 && n == 0) {
      return 1;
    }
    if (cache[m][n] != 0) {
      return cache[m][n];
    }
    cache[m][n] = checkValidPath(m - 1, n) + checkValidPath(m, n - 1);
    return cache[m][n];
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length, n = obstacleGrid[0].length, i, j;
    cache = obstacleGrid;
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        if (cache[i][j] == 1) {
          cache[i][j] = Integer.MIN_VALUE;
        }
      }
    }
    return checkValidPath(m - 1, n - 1);
  }
}