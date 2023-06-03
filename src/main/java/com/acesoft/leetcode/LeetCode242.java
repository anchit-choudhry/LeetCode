package com.acesoft.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 *  https://leetcode.com/problems/valid-anagram
 *
 *  Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 *  Example 1:
 *  Input: s = "anagram", t = "nagaram"
 *  Output: true
 *
 *  Example 2:
 *  Input: s = "rat", t = "car"
 *  Output: false
 *
 *  Note:
 *  You may assume the string contains only lowercase alphabets.
 *
 *  Follow up:
 *  What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class LeetCode242 {

  public boolean isAnagram(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> sMap = new HashMap<>();
    for (Character chars : s.toCharArray()) {
      if (sMap.containsKey(chars)) {
        Integer val = sMap.get(chars);
        sMap.put(chars, ++val);
      } else {
        sMap.put(chars, 1);
      }
    }
    for (Character chars : t.toCharArray()) {
      Integer val = sMap.get(chars);
      if (val == null || val == 0) {
        return false;
      } else {
        if (val == 1) {
          sMap.remove(chars);
          continue;
        }
        sMap.put(chars, --val);
      }
    }
    return sMap.isEmpty();
  }

  // Optimized solution using Array of 26 index of a-z
  public boolean isAnagram1(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }
    int i;
    int[] alphabets = new int[26];
    for (i = 0; i < t.length(); i++) {
      --alphabets[s.charAt(i) - 97];
      ++alphabets[t.charAt(i) - 97];

    }
    for (int a : alphabets) {
      if (a != 0) {
        return false;
      }
    }
    return true;
  }

  // Optimized solution using Array of 26 index of a-z and early exit
  public boolean isAnagram2(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }
    int i;
    int[] alphabets = new int[26];
    for (i = 0; i < s.length(); i++) {
      ++alphabets[s.charAt(i) - 97];
    }
    for (i = 0; i < t.length(); i++) {
      --alphabets[t.charAt(i) - 97];
      if (alphabets[t.charAt(i) - 97] < 0) {
        return false;
      }
    }
    return true;
  }
}