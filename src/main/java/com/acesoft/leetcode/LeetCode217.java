package com.acesoft.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/contains-duplicate
 *
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should
 * return false if every element is distinct.
 *
 * Example 1:
 * Input: [1,2,3,1]
 * Output: true
 *
 * Example 2:
 * Input: [1,2,3,4]
 * Output: false
 *
 * Example 3:
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public final class LeetCode217 {

  // Naive solution
  public boolean containsDuplicate(final int[] nums) {
    int i;
    final Set<Integer> num = new HashSet<>();
    for (i = 0; i < nums.length; i++) {
      if (num.contains(nums[i])) {
        return true;
      }
      num.add(nums[i]);
    }
    return false;
  }

  // Optimal solution using a Set
  public boolean containsDuplicate1(final int[] nums) {
    int i;
    final Set<Integer> num = new HashSet<>();
    for (i = 0; i < nums.length; i++) {
      if (!num.add(nums[i])) {
        return true;
      }
    }
    return false;
  }
}
