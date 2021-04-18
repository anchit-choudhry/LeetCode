package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/product-of-array-except-self
 * 
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product
 * of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * 
 * Constraints:
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * 
 * Follow up:
 * Could you solve it in O(n) time complexity and without using division?
 * Could you solve it with O(1) constant space complexity? (The output array does not count as
 * extra space for space complexity analysis.)
 */
public class LeetCode238 {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int i, right = 1;
        result[0] = 1;
        for (i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        for (i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}