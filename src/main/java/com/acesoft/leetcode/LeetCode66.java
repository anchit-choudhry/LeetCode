package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/plus-one
 *
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to
 * the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each
 * element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * Example 3:
 * Input: digits = [0]
 * Output: [1]
 *
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class LeetCode66 {

  // Optimal solution
  public int[] plusOne(int[] digits) {
    int carry = 1, i;
    for (i = digits.length - 1; i > -1; i--) {
      if (carry == 1) {
        if (digits[i] == 9) {
          digits[i] = 0;
          carry = 1;
        } else {
          digits[i]++;
          return digits;
        }
      }
    }
    int[] newDigits = new int[digits.length + 1];
    newDigits[0] = 1;
    return newDigits;
  }

  // Suboptimal solution
  public int[] plusOne1(int[] digits) {
    int i, carry = 0;
    for (i = digits.length - 1; i >= 0; i--) {
      digits[i] = i == digits.length - 1 ? digits[i] + 1 + carry : digits[i] + carry;
      if (digits[i] > 9) {
        digits[i] -= 10;
        carry = 1;
      } else {
        carry = 0;
      }
    }
    if (carry == 1) {
      int[] newRes = new int[digits.length + 1];
      newRes[0] = 1;
      for (i = 0; i < digits.length; i++) {
        newRes[i + 1] = digits[i];
      }
      return newRes;
    }
    return digits;
  }
}
