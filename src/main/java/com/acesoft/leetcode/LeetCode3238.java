package com.acesoft.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/find-the-number-of-winning-players
 *
 * You are given an integer n representing the number of players in a game and a 2D array pick
 * where pick[i] = [xi, yi] represents that the player xi picked a ball of color yi.
 *
 * Player i wins the game if they pick strictly more than i balls of the same color. In other words,
 *
 * Player 0 wins if they pick any ball.
 * Player 1 wins if they pick at least two balls of the same color.
 * ...
 * Player i wins if they pick at least i + 1 balls of the same color.
 *
 * Return the number of players who win the game.
 *
 * Note that multiple players can win the game.
 *
 * Example 1:
 * Input: n = 4, pick = [[0,0],[1,0],[1,0],[2,1],[2,1],[2,0]]
 * Output: 2
 * Explanation:
 * Player 0 and player 1 win the game, while players 2 and 3 do not win.
 *
 * Example 2:
 * Input: n = 5, pick = [[1,1],[1,2],[1,3],[1,4]]
 * Output: 0
 * Explanation:
 * No player wins the game.
 *
 * Example 3:
 * Input: n = 5, pick = [[1,1],[2,4],[2,4],[2,4]]
 * Output: 1
 * Explanation:
 * Player 2 wins the game by picking 3 balls with color 4.
 *
 * Constraints:
 * 2 <= n <= 10
 * 1 <= pick.length <= 100
 * pick[i].length == 2
 * 0 <= xi <= n - 1
 * 0 <= yi <= 10
 */
public final class LeetCode3238 {

  public int winningPlayerCount(final int n, final int[][] pick) {
    final Map<Integer, Map<Integer, Integer>> frequency = new HashMap<>();
    int count = 0, countOnes = 0;
    for (final int[] selection : pick) {
      if (selection[0] == 0) {
        countOnes = 1;
        continue;
      }
      Map<Integer, Integer> playerFrequency = new HashMap<>();
      if (frequency.containsKey(selection[0])) {
        playerFrequency = frequency.get(selection[0]);
        if (playerFrequency.containsKey(selection[1])) {
          playerFrequency.put(selection[1], playerFrequency.get(selection[1]) + 1);
        } else {
          playerFrequency.put(selection[1], 1);
        }
      } else {
        playerFrequency.put(selection[1], 1);
      }
      frequency.put(selection[0], playerFrequency);
    }
    for (final Map.Entry<Integer, Map<Integer, Integer>> playersMap : frequency.entrySet()) {
      final int playerName = playersMap.getKey();
      boolean flag = false;
      for (final Map.Entry<Integer, Integer> keyValue : playersMap.getValue().entrySet()) {
        if (keyValue.getValue() > playerName) {
          flag = true;
          break;
        }
      }
      if (flag) {
        count++;
      }
    }
    return count + countOnes;
  }
}
