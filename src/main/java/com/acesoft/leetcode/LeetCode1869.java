package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros
 *
 * Given a binary string s, return true if the longest contiguous segment of 1s is strictly longer
 * than the longest contiguous segment of 0s in s. Return false otherwise.
 *
 * For example, in s = "110100010" the longest contiguous segment of 1s has length 2, and the longest
 * contiguous segment of 0s has length 3.
 * Note that if there are no 0s, then the longest contiguous segment of 0s is considered to have
 * length 0. The same applies if there are no 1s.
 *
 *
 * Example 1:
 * Input: s = "1101"
 * Output: true
 * Explanation:
 * The longest contiguous segment of 1s has length 2: "1101"
 * The longest contiguous segment of 0s has length 1: "1101"
 * The segment of 1s is longer, so return true.
 *
 * Example 2:
 * Input: s = "111000"
 * Output: false
 * Explanation:
 * The longest contiguous segment of 1s has length 3: "111000"
 * The longest contiguous segment of 0s has length 3: "111000"
 * The segment of 1s is not longer, so return false.
 *
 * Example 3:
 * Input: s = "110100010"
 * Output: false
 * Explanation:
 * The longest contiguous segment of 1s has length 2: "110100010"
 * The longest contiguous segment of 0s has length 3: "110100010"
 * The segment of 1s is not longer, so return false.
 *
 * Constraints:
 * 1 <= s.length <= 100
 * s[i] is either '0' or '1'
 */
public class LeetCode1869 {

  public boolean checkZeroOnes(String s) {
    int ones = 0, tempOnes = 0, tempZeros = 0, zeros = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '0') {
        if (tempOnes > ones) {
          ones = tempOnes;
        }
        tempOnes = 0;
        tempZeros++;
      } else {
        if (tempZeros > zeros) {
          zeros = tempZeros;
        }
        tempZeros = 0;
        tempOnes++;
      }
    }
    return Math.max(ones, tempOnes) > Math.max(zeros, tempZeros);
  }
}
