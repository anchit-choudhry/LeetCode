package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/hamming-distance
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding
 * bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */
public class LeetCode461 {

  // Naive solution
  public int hammingDistance(int x, int y) {
    if (x == y) {
      return 0;
    }
    String xAsB = intToBinaryReversed(x), yAsB = intToBinaryReversed(y);
    int hamDist = 0, i = 0;
    while (i < xAsB.length() && i < yAsB.length()) {
      if (xAsB.charAt(i) != yAsB.charAt(i)) {
        hamDist++;
      }
      i++;
    }
    while (i < xAsB.length()) {
      if (xAsB.charAt(i) != '0') {
        hamDist++;
      }
      i++;
    }
    while (i < yAsB.length()) {
      if (yAsB.charAt(i) != '0') {
        hamDist++;
      }
      i++;
    }
    return hamDist;
  }

  // Using Bit manipulation
  public int hammingDistance1(int x, int y) {
    return x == y ? 0 : Integer.bitCount(x ^ y);
  }

  private String intToBinaryReversed(int num) {
    StringBuilder iAsB = new StringBuilder();
    while (num > 0) {
      iAsB.append(num % 2 == 0 ? '0' : '1');
      num /= 2;
    }
    return iAsB.toString();
  }
}
