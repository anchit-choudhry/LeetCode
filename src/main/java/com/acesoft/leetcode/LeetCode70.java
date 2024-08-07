package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/climbing-stairs
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 * 1 <= n <= 45
 */
public final class LeetCode70 {

  private final int[] cache = new int[46];

  public int climbStairs(final int n) {
    if (n < 1) {
      return 0;
    }
    if (n < 3) {
      return n;
    }
    if (cache[n] != 0) {
      return cache[n];
    }
    final int count = climbStairs(n - 1) + climbStairs(n - 2);
    cache[n] = count;
    return count;
  }
}
