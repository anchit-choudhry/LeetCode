package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/first-unique-character-in-a-string
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it
 * doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 */
public class LeetCode387 {

  // Suboptimal solution
  public int firstUniqChar(String s) {
    int[] alphabets = new int[26];
    int i;
    for (i = 0; i < s.length(); i++) {
      ++alphabets[s.charAt(i) - 97];
    }
    for (i = 0; i < s.length(); i++) {
      if (alphabets[s.charAt(i) - 97] == 1) {
        return i;
      }
    }
    return -1;
  }

  // Optimal solution
  public int firstUniqChar1(String s) {
    int[] alphabets = new int[26];
    int i, index = Integer.MAX_VALUE;
    for (i = 0; i < s.length(); i++) {
      int pos = s.charAt(i) - 97;
      if (alphabets[pos] == 0) {
        alphabets[pos] = i + 1;
      } else {
        alphabets[pos] = -1;
      }
    }
    for (i = 0; i < 26; i++) {
      if (alphabets[i] > 0 && alphabets[i] < index) {
        index = alphabets[i];
      }
    }
    return index == Integer.MAX_VALUE ? -1 : index - 1;
  }
}
