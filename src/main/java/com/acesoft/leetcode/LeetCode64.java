package com.acesoft.leetcode;

import java.lang.Math;

/*
 * https://leetcode.com/problems/minimum-path-sum
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 *
 * Example 1:
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * Example 2:
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class LeetCode64 {

    private int[][] cache;

    private int getShortestPath(int m, int n, int[][] grid) {
        if (m == 0 && n == 0) {
            return grid[m][n];
        }
        if (cache[m][n] != 0) {
            return cache[m][n];
        }
        if (m == 0) {
            cache[m][n] = grid[m][n] + getShortestPath(m, n - 1, grid);
            return cache[m][n];
        }
        if (n == 0) {
            cache[m][n] = grid[m][n] + getShortestPath(m - 1, n, grid);
            return cache[m][n];
        }
        cache[m][n] = grid[m][n] + Math.min(getShortestPath(m - 1, n, grid), getShortestPath(m, n - 1, grid));
        return cache[m][n];
    }

    public int minPathSum(int[][] grid) {
        int x = grid.length, y = grid[0].length;
        cache = new int[x][y];
        return getShortestPath(x - 1, y - 1, grid);
    }
}