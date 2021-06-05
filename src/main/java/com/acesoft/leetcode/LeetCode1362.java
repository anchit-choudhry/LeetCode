package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/closest-divisors
 *
 *  Given an integer num, find the closest two integers in absolute difference whose product
 *  equals num + 1 or num + 2.
 *
 *  Return the two integers in any order. 
 *
 *  Example 1:
 *  Input: num = 8
 *  Output: [3,3]
 *  Explanation: For num + 1 = 9, the closest divisors are 3 & 3, for num + 2 = 10, the closest
 *  divisors are 2 & 5, hence 3 & 3 is chosen.
 *
 *  Example 2:
 *  Input: num = 123
 *  Output: [5,25]
 *
 *  Example 3:
 *  Input: num = 999
 *  Output: [40,25]
 * 
 *  Constraints:
 *  1 <= num <= 10^9
 */
public class LeetCode1362 {

    // Suboptimal solution
    public int[] closestDivisors(int num) {
        int[] first = null, second = null;
        int i, diff1, diff2;
        for (i = 1; i <= Math.sqrt(num + 1); i++) {
            if ((num + 1) % i == 0) {
                if (first == null) {
                    first = new int[] { i, (num + 1) / i };
                } else {
                    diff1 = ((num + 1) / i) - i;
                    diff1 = diff1 < 0 ? diff1 * -1 : diff1;
                    diff2 = first[0] - first[1];
                    diff2 = diff2 < 0 ? diff2 * -1 : diff2;
                    if (diff1 < diff2) {
                        first = new int[] { i, (num + 1) / i };
                    }
                }
            }
        }
        for (i = 1; i <= Math.sqrt(num + 2); i++) {
            if ((num + 2) % i == 0) {
                if (second == null) {
                    second = new int[] { i, (num + 2) / i };
                } else {
                    diff1 = ((num + 2) / i) - i;
                    diff1 = diff1 < 0 ? diff1 * -1 : diff1;
                    diff2 = second[0] - second[1];
                    diff2 = diff2 < 0 ? diff2 * -1 : diff2;
                    if (diff1 < diff2) {
                        second = new int[] { i, (num + 2) / i };
                    }
                }
            }
        }
        diff1 = first[0] - first[1];
        diff1 = diff1 < 0 ? diff1 * -1 : diff1;
        diff2 = second[0] - second[1];
        diff2 = diff2 < 0 ? diff2 * -1 : diff2;
        return diff1 < diff2 ? first : second;
    }
}