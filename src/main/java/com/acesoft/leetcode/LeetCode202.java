package com.acesoft.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/happy-number
 *
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the
 * number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 * Input: 19
 * Output: true
 *
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class LeetCode202 {

  public boolean isHappy(int n) {
    Set<Integer> hs = new HashSet<>();
    int mod, sum;
    while (hs.add(n)) {
      sum = 0;
      while (n != 0) {
        mod = n % 10;
        n /= 10;
        sum += mod * mod;
      }
      if (sum == 1) {
        return true;
      }
      n = sum;
    }
    return false;
  }
}
