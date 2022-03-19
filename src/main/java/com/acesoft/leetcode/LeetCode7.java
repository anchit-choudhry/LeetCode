package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/reverse-integer
 *
 *  Given a 32-bit signed integer, reverse digits of an integer.
 *
 *  Example 1:
 *  Input: 123
 *  Output: 321
 *
 *  Example 2:
 *  Input: -123
 *  Output: -321
 *
 *  Example 3:
 *  Input: 120
 *  Output: 21
 *
 *  Note:
 *  Assume we are dealing with an environment which could only store integers within the 32-bit
 *  signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your
 *  function returns 0 when the reversed integer overflows.
 */
public class LeetCode7 {

    // Optimal solution
    public int reverse(int x) {
        int num = 0, exp = 0, copy = x;
        while (copy != 0) {
            exp++;
            copy /= 10;
        }
        copy = x;
        while (copy != 0) {
            num += (int) Math.pow(10, --exp) * (copy % 10);
            copy /= 10;
        }
        return num == Integer.MAX_VALUE || num == Integer.MIN_VALUE ? 0 : num;
    }

    // Suboptimal solution
    public int reverse1(int x) {
        if (x == 0) {
            return x;
        }
        int num = x < 0 ? x * -1 : x;
        int rem, finalN;
        StringBuilder s = new StringBuilder();
        while (num != 0) {
            rem = num % 10;
            num /= 10;
            s.append(Integer.toString(rem));
        }
        try {
            finalN = Integer.parseInt(s.toString()) * (x < 0 ? -1 : 1);
        } catch (NumberFormatException e) {
            finalN = 0;
        }
        return finalN;
    }
}