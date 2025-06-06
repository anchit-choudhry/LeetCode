package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/ransom-note
 *
 * Given an arbitrary ransom note string and another string containing letters from all the
 * magazines, write a function that will return true if the ransom note can be constructed from
 * the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 *
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 * Constraints:
 * You may assume that both strings contain only lowercase letters.
 */
public class LeetCode383 {

  public boolean canConstruct(String ransomNote, String magazine) {
    int[] chars = new int[26];
    for (char ch : magazine.toCharArray()) {
      chars[ch - 97]++;
    }
    for (char ch : ransomNote.toCharArray()) {
      if (--chars[ch - 97] < 0) {
        return false;
      }
    }
    return true;
  }
}
