package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/valid-perfect-square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square
 * else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 * Input: 16
 * Output: true
 *
 * Example 2:
 * Input: 14
 * Output: false
 */
public class LeetCode367 {

  public boolean isPerfectSquare(int num) {
    int low = 1, high = num, middle, rem;
    while (low <= high) {
      middle = low + (high - low) / 2;
      rem = num / middle;
      if (num / middle == middle && num % middle == 0) {
        return true;
      } else if (rem < middle) {
        high = middle - 1;
      } else {
        low = middle + 1;
      }
    }
    return false;
  }
}
