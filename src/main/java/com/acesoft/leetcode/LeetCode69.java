package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/sqrtx
 *
 *  Implement int sqrt(int x).
 *
 *  Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 *  Since the return type is an integer, the decimal digits are truncated and only the integer part
 *  of the result is returned.
 *
 *  Example 1:
 *  Input: 4
 *  Output: 2
 *
 *  Example 2:
 *  Input: 8
 *  Output: 2
 *  Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated,
 *  2 is returned.
 */
public class LeetCode69 {

    // Naive solution with O(sqrt[n]) complexity
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        for (int i = 1; i <= x / i; i++) {
            if (i <= x / i && i + 1 > x / (i + 1)) {
                return i;
            }
        }
        return -1;
    }

    // Optimal solution using Binary search
    public int mySqrt1(int x) {
        if (x == 0) {
            return x;
        }
        int low = 1, mid, high = x;
        while (low < high) {
            // To avoid integer overflow
            mid = low + (high - low) / 2;
            // Used i <= x / i instead of i * i <= x to avoid integer overflow
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid > x / mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}