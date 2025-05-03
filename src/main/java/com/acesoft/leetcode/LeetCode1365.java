package com.acesoft.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number
 *
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 *
 * Example 1:
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 *
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 *
 * Example 2:
 * Input: nums = [6,5,4,8]
 * Output: [2,1,0,3]
 *
 * Example 3:
 * Input: nums = [7,7,7,7]
 * Output: [0,0,0,0]
 *
 * Constraints:
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class LeetCode1365 {

  // Optimal solution
  public int[] smallerNumbersThanCurrent(int[] nums) {
    if (nums.length < 1) {
      return new int[]{};
    }
    int i;
    int[] arr = new int[nums.length], temp = new int[101];
    for (i = 0; i < nums.length; i++) {
      temp[nums[i]]++;
    }
    for (i = 1; i < 101; i++) {
      temp[i] += temp[i - 1];
    }
    for (i = 0; i < nums.length; i++) {
      arr[i] = nums[i] == 0 ? 0 : temp[nums[i] - 1];
    }
    return arr;
  }

  // Sub optimal solution
  public int[] smallerNumbersThanCurrent1(int[] nums) {
    if (nums.length < 1) {
      return new int[]{};
    }
    int i, j, count;
    int[] arr = new int[nums.length];
    Map<Integer, Integer> hs = new HashMap<>();
    for (i = 0; i < nums.length; i++) {
      if (hs.get(nums[i]) != null) {
        arr[i] = hs.get(nums[i]);
        continue;
      }
      count = 0;
      for (j = 0; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          count++;
        }
      }
      hs.put(nums[i], count);
      arr[i] = count;
    }
    return arr;
  }

  // Naive solution
  public int[] smallerNumbersThanCurrent2(int[] nums) {
    if (nums.length < 1) {
      return new int[]{};
    }
    int i, j, count;
    int[] arr = new int[nums.length];

    for (i = 0; i < nums.length; i++) {
      count = 0;
      for (j = 0; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          count++;
        }
      }
      arr[i] = count;
    }
    return arr;
  }
}