package com.acesoft.leetcode;

import java.util.Stack;

/*
 * https://leetcode.com/problems/valid-parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if
 * the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([)]"
 * Output: false
 *
 * Example 5:
 * Input: s = "{[]}"
 * Output: true
 *
 * Constraints:
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 */
public class LeetCode20 {

  public boolean isValid(String s) {
    Stack<Character> st = new Stack<>();
    for (char ch : s.toCharArray()) {
      if (ch == '(' || ch == '{' || ch == '[') {
        st.push(ch);
      } else if (st.empty() || (ch == ')' && st.pop() != '(')
          || (ch == '}' && st.pop() != '{') || (ch == ']' && st.pop() != '[')) {
        return false;
      }
    }
    return st.empty();
  }
}
