package com.acesoft.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  https://leetcode.com/problems/group-anagrams
 *
 *  Given an array of strings, group anagrams together.
 *
 *  Example:
 *  Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 *  Output:
 *  [
 *    ["ate","eat","tea"],
 *    ["nat","tan"],
 *    ["bat"]
 *  ]
 *
 *  Note:
 *  All inputs will be in lowercase.
 *  The order of your output does not matter.
 */
public final class LeetCode49 {

  // Optimal solution
  public List<List<String>> groupAnagrams(final String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }
    final List<List<String>> result = new ArrayList<>();
    if (strs.length == 1) {
      result.add(Arrays.asList(strs));
      return result;
    }
    final Map<String, List<String>> words = new HashMap<>();
    for (final String str : strs) {
      final char[] charArr = new char[26];
      for (char ch : str.toCharArray()) {
        charArr[ch - 97]++;
      }
      final String cArrToStr = String.valueOf(charArr);
      if (!words.containsKey(cArrToStr)) {
        words.put(cArrToStr, new ArrayList<>());
      }
      words.get(cArrToStr).add(str);
    }
    return new ArrayList<>(words.values());
  }
}
