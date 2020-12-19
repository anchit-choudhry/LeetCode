package com.acesoft.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 *  https://leetcode.com/problems/number-of-good-pairs
 *  
 *  Given an array of integers nums.
 *  
 *  A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 *  
 *  Return the number of good pairs.
 *  
 *  Example 1:
 *  Input: nums = [1,2,3,1,1,3]
 *  Output: 4
 *  Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 *  
 *  Example 2:
 *  Input: nums = [1,1,1,1]
 *  Output: 6
 *  Explanation: Each pair in the array are good.
 *  
 *  Example 3:
 *  Input: nums = [1,2,3]
 *  Output: 0
 *  
 *  Constraints:
 *  1 <= nums.length <= 100
 *  1 <= nums[i] <= 100
 */
public class LeetCode1512 {

    // Optimal solution O(n); can be further optimized by using an index based arr of length 100
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int num : nums) {
            lookup.put(num, lookup.getOrDefault(num, 0) + 1);
            count += lookup.get(num) - 1;
        }
        return count;
    }

    // Suboptimal solution O(n^2)
    public int numIdenticalPairs1(int[] nums) {
        int count = 0, i, j;
        for (i = 0; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}