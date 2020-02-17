package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side
 *
 *  Given an array arr, replace every element in that array with the greatest element among the
 *  elements to its right, and replace the last element with -1.
 *
 *  After doing so, return the array.
 *
 *  Example 1:
 *
 *  Input: arr = [17,18,5,4,6,1]
 *  Output: [18,6,6,6,1,-1]
 * 
 *  Constraints:
 *
 *  1 <= arr.length <= 10^4
 *  1 <= arr[i] <= 10^5
 */
public class LeetCode1299 {
	public int[] replaceElements(int[] arr) {
		if (arr.length < 2) {
			return new int[] { -1 };
		}
		int i, max = -1, temp = max;
		for (i = arr.length - 1; i > -1; i--) {
			max = arr[i];
			arr[i] = temp;
			max = temp = Math.max(max, temp);
		}
		return arr;
	}
}