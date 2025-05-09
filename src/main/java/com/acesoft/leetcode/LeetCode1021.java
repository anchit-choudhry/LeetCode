package com.acesoft.leetcode;

import java.util.Stack;

/*
 * https://leetcode.com/problems/remove-outermost-parentheses
 *
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid
 * parentheses strings, and + represents string concatenation. For example, "", "()", "(())()",
 * and "(()(()))" are all valid parentheses strings.
 *
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split
 * it into S = A+B, with A and B nonempty valid parentheses strings.
 *
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k,
 * where P_i are primitive valid parentheses strings.
 *
 * Return S after removing the outermost parentheses of every primitive string in the primitive
 * decomposition of S.
 *
 * Example 1:
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 *
 * Example 2:
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 *
 * Example 3:
 * Input: "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 *
 * Note:
 * S.length <= 10000
 * S[i] is "(" or ")"
 * S is a valid parentheses string
 */
public class LeetCode1021 {

  public String removeOuterParentheses(String S) {
    int open = 0;
    StringBuilder sb = new StringBuilder();
    for (char ch : S.toCharArray()) {
      if (ch == '(' && open++ > 0) {
        sb.append(ch);
      } else if (ch == ')' && --open > 0) {
        sb.append(ch);
      }
    }
    return sb.toString();
  }

  // Naive solution
  public String removeOuterParentheses1(String S) {
    Stack<Character> st = new Stack<>();
    StringBuilder sb = new StringBuilder();
    boolean wasEmpty;
    for (char ch : S.toCharArray()) {
      wasEmpty = st.empty();
      if (ch == '(') {
        st.push(ch);
        if (wasEmpty) {
          continue;
        }
      } else {
        if (wasEmpty) {
          continue;
        }
        st.pop();
        if (st.empty()) {
          continue;
        }
      }
      sb.append(ch);
    }
    return sb.toString();
  }
}