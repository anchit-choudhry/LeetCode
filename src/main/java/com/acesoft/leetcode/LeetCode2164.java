package com.acesoft.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/sort-even-and-odd-indices-independently
 *
 * You are given a 0-indexed integer array nums. Rearrange the values of nums according to the
 * following rules:
 *
 * 1. Sort the values at odd indices of nums in non-increasing order.
 * For example, if nums = [4,1,2,3] before this step, it becomes [4,3,2,1] after. The values at
 * odd indices 1 and 3 are sorted in non-increasing order.
 *
 * 2. Sort the values at even indices of nums in non-decreasing order.
 * For example, if nums = [4,1,2,3] before this step, it becomes [2,1,4,3] after. The values at
 * even indices 0 and 2 are sorted in non-decreasing order.
 *
 * Return the array formed after rearranging the values of nums.
 *
 * Example 1:
 * Input: nums = [4,1,2,3]
 * Output: [2,3,4,1]
 * Explanation:
 * First, we sort the values present at odd indices (1 and 3) in non-increasing order.
 * So, nums changes from [4,1,2,3] to [4,3,2,1].
 * Next, we sort the values present at even indices (0 and 2) in non-decreasing order.
 * So, nums changes from [4,1,2,3] to [2,3,4,1].
 * Thus, the array formed after rearranging the values is [2,3,4,1].
 *
 * Example 2:
 * Input: nums = [2,1]
 * Output: [2,1]
 * Explanation:
 * Since there is exactly one odd index and one even index, no rearrangement of values takes place.
 * The resultant array formed is [2,1], which is the same as the initial array.
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public final class LeetCode2164 {

  public int[] sortEvenOdd(final int[] nums) {
    int i;
    final List<Integer> odd = new ArrayList<>();
    final List<Integer> even = new ArrayList<>();
    final int[] sortedNums = new int[nums.length];

    for (i = 0; i < nums.length; i++) {
      if (i % 2 == 0) {
        even.add(nums[i]);
      } else {
        odd.add(nums[i]);
      }
    }

    odd.sort(Collections.reverseOrder());
    Collections.sort(even);

    i = 0;
    for (int num : even) {
      sortedNums[i] = num;
      i = i + 2;
    }
    i = 1;
    for (int num : odd) {
      sortedNums[i] = num;
      i = i + 2;
    }
    return sortedNums;
  }
}
