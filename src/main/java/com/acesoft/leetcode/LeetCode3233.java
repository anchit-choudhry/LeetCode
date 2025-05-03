package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/find-the-count-of-numbers-which-are-not-special
 *
 * You are given 2 positive integers l and r. For any number x, all positive divisors of x except x
 * are called the proper divisors of x.
 *
 * A number is called special if it has exactly 2 proper divisors. For example:
 *
 * The number 4 is special because it has proper divisors 1 and 2.
 * The number 6 is not special because it has proper divisors 1, 2, and 3.
 *
 * Return the count of numbers in the range [l, r] that are not special.
 *
 * Example 1:
 * Input: l = 5, r = 7
 * Output: 3
 * Explanation:
 * There are no special numbers in the range [5, 7].
 *
 * Example 2:
 * Input: l = 4, r = 16
 * Output: 11
 * Explanation:
 * The special numbers in the range [4, 16] are 4 and 9.
 *
 * Constraints:
 * 1 <= l <= r <= 10^9
 */
public final class LeetCode3233 {

  public int nonSpecialCount(final int l, final int r) {
    int i, count = 0, start = (int) Math.sqrt(l), end = (int) Math.sqrt(r);
    for (i = start; i <= end; i++) {
      if (i * i >= l && i * i <= r && isPrime(i)) {
        count++;
      }
    }
    return r - l + 1 - count;
  }

  private boolean isPrime(final int num) {
    if (num < 2) {
      return false;
    }
    if (num < 4) {
      return true;
    }
    if (num % 2 == 0 || num % 3 == 0) {
      return false;
    }
    int i;
    for (i = 5; i <= Math.sqrt(num); i = i + 6) {
      if (num % i == 0 || num % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }

}
