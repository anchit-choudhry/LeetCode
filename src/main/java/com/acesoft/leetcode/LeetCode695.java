package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/max-area-of-island
 * 
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are
 * surrounded by water.
 * 
 * The area of an island is the number of cells with a value 1 in the island.
 * 
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * 
 * Example 1:
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * 
 * Example 2:
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 * 
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */
public class LeetCode695 {

    private int[][] grid;
    private int max = 0, m, n;

    private int checkIsland(int x, int y, int sum) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return sum;
        }
        grid[x][y] = 0;
        sum++;
        sum = checkIsland(x + 1, y, sum);
        sum = checkIsland(x - 1, y, sum);
        sum = checkIsland(x, y + 1, sum);
        sum = checkIsland(x, y - 1, sum);
        return sum;
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int i, j, count = 0;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count = checkIsland(i, j, 0);
                    if (count > max) {
                        max = count;
                    }
                }
            }
        }
        return max;
    }
}