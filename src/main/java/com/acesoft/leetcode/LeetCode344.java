package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/reverse-string
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[]
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ASCII characters.
 *
 * Example 1:
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class LeetCode344 {

  public void reverseString(char[] s) {
    int i, len = s.length, temp;
    for (i = 0; i < len / 2; i++) {
      temp = s[i];
      s[i] = s[len - 1 - i];
      s[len - 1 - i] = (char) temp;
    }
  }
}
