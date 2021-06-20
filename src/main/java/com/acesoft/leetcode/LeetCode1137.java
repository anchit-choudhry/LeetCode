package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/n-th-tribonacci-number
 *
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 * Example 1:
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 *
 * Example 2:
 * Input: n = 25
 * Output: 1389537
 *
 * Constraints:
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, i.e. answer <= 2^31 - 1
 */
public class LeetCode1137 {

    private int[] fibo = new int[38];

    private int threebonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        if (fibo[n] != 0) {
            return fibo[n];
        }
        fibo[n] = threebonacci(n - 1) + threebonacci(n - 2) + threebonacci(n - 3);
        return fibo[n];
    }

    public int tribonacci(int n) {
        return threebonacci(n);
    }
}