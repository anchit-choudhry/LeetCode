package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/four-divisors
 *
 *  Given an integer array nums, return the sum of divisors of the integers in that array that
 *  have exactly four divisors.
 *
 *  If there is no such integer in the array, return 0.
 *
 *  Example 1:
 *  Input: nums = [21,4,7]
 *  Output: 32
 *  Explanation:
 *  21 has 4 divisors: 1, 3, 7, 21
 *  4 has 3 divisors: 1, 2, 4
 *  7 has 2 divisors: 1, 7
 *  The answer is the sum of divisors of 21 only.
 *
 *  Constraints:
 *  1 <= nums.length <= 10^4
 *  1 <= nums[i] <= 10^5
 */
public class LeetCode1390 {

    public int sumFourDivisors(int[] nums) {
        int sum = 0, localSum, i, div;
        for (int num : nums) {
            div = 2;
            localSum = 1 + num;
            for (i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    localSum += i == num / i ? i : num / i + i;
                    div += i == num / i ? 1 : 2;
                }
                if (div > 4) {
                    break;
                }
            }
            if (div == 4) {
                sum += localSum;
            }
        }
        return sum;
    }
}