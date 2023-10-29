package com.acesoft.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 *  https://leetcode.com/problems/count-integers-with-even-digit-sum
 *
 *  Given a positive integer num, return the number of positive integers less than or equal to num whose digit sums are even.
 *
 *  The digit sum of a positive integer is the sum of all its digits.
 *
 *  Example 1:
 *  Input: num = 4
 *  Output: 2
 *  Explanation:
 *  The only integers less than or equal to 4 whose digit sums are even are 2 and 4.
 *
 *  Example 2:
 *  Input: num = 30
 *  Output: 14
 *  Explanation:
 *  The 14 integers less than or equal to 30 whose digit sums are even are
 *  2, 4, 6, 8, 11, 13, 15, 17, 19, 20, 22, 24, 26, and 28.
 *
 *  Constraints:
 *  1 <= num <= 1000
 */
public class LeetCode2180 {

  final Set<Integer> numIsEven = new HashSet<>();
  final Set<Integer> numNotEven = new HashSet<>();

  public int countEven(int num) {
    int count = 0, i;
    for (i = num; i > 1; i--) {
      if (returnSumOfDigitsEven(i)) {
        count++;
      }
    }
    return count;
  }

  private boolean returnSumOfDigitsEven(int num) {
    if (numIsEven.contains(num)) {
      return true;
    }
    if (numNotEven.contains(num)) {
      return false;
    }
    int sum = 0;
    while (num != 0) {
      sum += num % 10;
      num /= 10;
    }
    if (sum % 2 == 0) {
      numIsEven.add(num);
      return true;
    }
    numNotEven.add(num);
    return false;
  }
}
