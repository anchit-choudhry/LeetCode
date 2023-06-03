package com.acesoft.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 *  https://leetcode.com/problems/majority-element
 *
 *  Given an array of size n, find the majority element. The majority element is the element that
 *  appears more than ⌊ n/2 ⌋ times.
 *
 *  You may assume that the array is non-empty and the majority element always exist in the array.
 *
 *  Example 1:
 *  Input: [3,2,3]
 *  Output: 3
 *
 *  Example 2:
 *  Input: [2,2,1,1,1,2,2]
 *  Output: 2
 */
public class LeetCode169 {

  public int majorityElement(int[] nums) {
    Map<Integer, Integer> majority = new HashMap<>();
    int size = nums.length / 2, temp;
    for (int num : nums) {
      temp = majority.getOrDefault(num, 0);
      if (temp == 0) {
        majority.put(num, 1);
      } else {
        if (temp + 1 > size) {
          return num;
        } else {
          majority.put(num, temp + 1);
        }
      }
    }
    return nums.length == 1 ? nums[0] : -1;
  }
}