package com.acesoft.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/decompress-run-length-encoded-list
 *
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 *
 * Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).
 * For each such pair, there are a elements with value b in the decompressed list.
 *
 * Return the decompressed list.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [2,4,4,4]
 * Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
 * The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
 * At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
 *
 * Constraints:
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 */
public class LeetCode1313 {

  public int[] decompressRLElist(int[] nums) {
    int i, count = 0;
    for (i = 0; i < nums.length; i = i + 2) {
      count += nums[i];
    }
    int[] arr = new int[count];
    count = 0;
    for (i = 0; i < nums.length; i = i + 2) {
      // Should use below for optimal solution
      Arrays.fill(arr, count, count += nums[i], nums[i + 1]);
      // Sub optimal solution: for (j = 0; j < nums[i]; j++) { arr[count++] = nums[i + 1]; }
    }
    return arr;
  }
}