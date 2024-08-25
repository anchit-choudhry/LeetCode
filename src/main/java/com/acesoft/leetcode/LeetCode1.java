package com.acesoft.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 *  https://leetcode.com/problems/two-sum
 *
 *  Given an array of integers, return indices of the two numbers such that they add up to a
 *  specific target.
 *
 *  You may assume that each input would have exactly one solution, and you may not use the same
 *  element twice.
 *
 *  Example:
 *  Given nums = [2, 7, 11, 15], target = 9,
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 */
public final class LeetCode1 {

  // Naive solution
  public int[] twoSum(int[] nums, int target) {
    int elemTwo;
    for (int i = 0; i < nums.length; i++) {
      elemTwo = target - nums[i];
      for (int j = 0; j < nums.length; j++) {
        if (i == j) {
          continue;
        }
        if (nums[j] == elemTwo) {
          return new int[]{i, j};
        }
      }
    }
    return new int[2];
  }

  // Improved solution
  public int[] twoSum1(int[] nums, int target) {
    int elemTwo, index;
    Map<Integer, Integer> dict = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      elemTwo = target - nums[i];
      /*
       * Special case when the same number is at another position and sum equals
       * target Example: [3, 3], target = 6, return [0, 1].
       */
      if (nums[i] == elemTwo && dict.containsKey(elemTwo)) {
        index = dict.get(elemTwo);
        return new int[]{index, i};
      }
      dict.put(nums[i], i);
      if (dict.containsKey(elemTwo)) {
        index = dict.get(elemTwo);
        if (index != i) {
          return new int[]{index, i};
        }
      }
    }
    return new int[2];
  }

  // Improved solution #2
  public int[] twoSum2(final int[] nums, final int target) {
    int i, first = -1, second = -1, temp;
    Integer tempIndex;
    final Map<Integer, Integer> index = new HashMap<>();
    for (i = 0; i < nums.length; i++) {
      temp = target - nums[i];
      tempIndex = index.get(temp);
      if (index.get(temp) != null) {
        return new int[]{tempIndex, i};
      }
      index.put(nums[i], i);
    }
    return new int[]{first, second};
  }
}