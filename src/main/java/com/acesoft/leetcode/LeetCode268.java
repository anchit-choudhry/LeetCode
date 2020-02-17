package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/missing-number
 *
 *  Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 *  Example 1:
 *
 *  Input: [3,0,1]
 *  Output: 2
 *  Example 2:
 *
 *  Input: [9,6,4,2,3,5,7,0,1]
 *  Output: 8
 *  Note:
 *  Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class LeetCode268 {

    // Optimal Solution using Formula
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return (nums.length * (nums.length + 1) / 2) - sum;
    }

    // Optimal Solution using XOR
    public int missingNumber1(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res;
    }
}