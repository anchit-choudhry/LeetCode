package com.acesoft.leetcode;

import java.util.Stack;

/*
 *  Given two strings S and T, return if they are equal when both are typed into empty text editors.
 *  # means a backspace character.
 *
 *  Note that after backspacing an empty text, the text will continue empty.
 *
 *  Example 1:
 *  Input: S = "ab#c", T = "ad#c"
 *  Output: true
 *  Explanation: Both S and T become "ac".
 *
 *  Example 2:
 *  Input: S = "ab##", T = "c#d#"
 *  Output: true
 *  Explanation: Both S and T become "".
 *
 *  Example 3:
 *  Input: S = "a##c", T = "#a#c"
 *  Output: true
 *  Explanation: Both S and T become "c".
 *
 *  Example 4:
 *  Input: S = "a#c", T = "b"
 *  Output: false
 *  Explanation: S becomes "c" while T becomes "b".
 *
 *  Note:
 *  1 <= S.length <= 200
 *  1 <= T.length <= 200
 *  S and T only contain lowercase letters and '#' characters.
 *
 *  Follow up:
 *  Can you solve it in O(N) time and O(1) space?
 */
public class LeetCode844 {

  // Subooptimal solution using Stack
  public boolean backspaceCompare(String S, String T) {
    int i;
    Stack<Character> ss = new Stack<>();
    Stack<Character> tt = new Stack<>();
    for (i = 0; i < S.length(); i++) {
      if (S.charAt(i) == '#') {
        if (ss.size() > 0) {
          ss.pop();
        }
      } else {
        ss.push(S.charAt(i));
      }
    }
    for (i = 0; i < T.length(); i++) {
      if (T.charAt(i) == '#') {
        if (tt.size() > 0) {
          tt.pop();
        }
      } else {
        tt.push(T.charAt(i));
      }
    }
    if (ss.size() != tt.size()) {
      return false;
    }
    while (tt.size() != 0) {
      if (!tt.pop().equals(ss.pop())) {
        return false;
      }
    }
    return true;
  }
}