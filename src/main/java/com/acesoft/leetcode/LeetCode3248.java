package com.acesoft.leetcode;

import java.util.List;

/*
 *  https://leetcode.com/problems/snake-in-matrix
 *
 *  There is a snake in an n x n matrix grid and can move in four possible directions. Each cell in
 *  the grid is identified by the position: grid[i][j] = (i * n) + j.
 *
 *  The snake starts at cell 0 and follows a sequence of commands.
 *
 *  You are given an integer n representing the size of the grid and an array of strings commands
 *  where each command[i] is either "UP", "RIGHT", "DOWN", and "LEFT". It's guaranteed that the
 *  snake will remain within the grid boundaries throughout its movement.
 *
 *  Return the position of the final cell where the snake ends up after executing commands.
 *
 *  Example 1:
 *  Input: n = 2, commands = ["RIGHT","DOWN"]
 *  Output: 3
 *
 *  Example 2:
 *  Input: n = 3, commands = ["DOWN","RIGHT","UP"]
 *  Output: 1
 *
 *  Constraints:
 *  2 <= n <= 10
 *  1 <= commands.length <= 100
 *  commands consists only of "UP", "RIGHT", "DOWN", and "LEFT".
 *  The input is generated such the snake will not move outside of the boundaries.
 */
public final class LeetCode3248 {

  public int finalPositionOfSnake(final int n, final List<String> commands) {
    int row = 0, column = 0;
    for (final String command : commands) {
      switch (command) {
        case "LEFT":
          column--;
          break;
        case "RIGHT":
          column++;
          break;
        case "UP":
          row--;
          break;
        case "DOWN":
          row++;
          break;
        default:
          throw new RuntimeException("Invalid input received");
      }
    }
    return (n * row) + column;
  }
}
