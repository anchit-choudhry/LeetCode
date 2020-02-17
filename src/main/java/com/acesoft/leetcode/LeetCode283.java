package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/move-zeroes  
 *
 *  Given an array nums, write a function to move all 0's to the end of it while maintaining the
 *  relative order of the non-zero elements.
 *
 *  Example:
 *
 *  Input: [0,1,0,3,12]
 *  Output: [1,3,12,0,0]
 *  Note:
 *
 *  You must do this in-place without making a copy of the array.
 *  Minimize the total number of operations.
 */
public class LeetCode283 {

	public void moveZeroes(int[] nums) {
		int i, j = 0;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[j++] = nums[i];
			}
		}
		for (i = j; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}