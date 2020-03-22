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
        Map<Integer, Integer> count = new HashMap<>();
        int i, num = 0;
        for (i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            } else {
                count.put(nums[i], 1);
            }
        }
        i = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > i) {
                num = entry.getKey();
                i = entry.getValue();
            }
        }
        return num;
    }
}