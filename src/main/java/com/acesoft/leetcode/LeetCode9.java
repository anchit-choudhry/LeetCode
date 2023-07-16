package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/palindrome-number
 *
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is
 * palindrome while 123 is not.
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore
 * it is not a palindrome.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Example 4:
 * Input: x = -101
 * Output: false
 *
 * Constraints:
 * -2^31 <= x <= 2^31 - 1
 *
 */
public class LeetCode9 {

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    if (x < 10) {
      return true;
    }
    int len = 0, i = 0;
    int[] arr = new int[10];
    while (x != 0) {
      arr[i++] = x % 10;
      x /= 10;
      len++;
    }
    for (i = 0; i < len / 2; i++) {
      if (arr[i] != arr[len - 1 - i]) {
        return false;
      }
    }
    return true;
  }
}
