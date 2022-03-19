package com.acesoft.leetcode;

import java.util.Arrays;
import java.util.Collections;

/*
 *  https://leetcode.com/problems/smallest-value-of-the-rearranged-number
 *
 *  You are given an integer num. Rearrange the digits of num such that its value is minimized and
 *  it does not contain any leading zeros.
 *
 *  Return the rearranged number with minimal value.
 *
 *  Note that the sign of the number does not change after rearranging the digits.
 *
 *  Example 1:
 *  Input: num = 310
 *  Output: 103
 *  Explanation: The possible arrangements for the digits of 310 are 013, 031, 103, 130, 301, 310.
 *  The arrangement with the smallest value that does not contain any leading zeros is 103.
 *
 *  Example 2:
 *  Input: num = -7605
 *  Output: -7650
 *  Explanation: Some possible arrangements for the digits of -7605 are -7650, -6705, -5076, -0567.
 *  The arrangement with the smallest value that does not contain any leading zeros is -7650.
 *
 *  Constraints:
 *  -10^15 <= num <= 10^15
 */
public class LeetCode2165 {

    public long smallestNumber(long num) {
        if (num == 0) {
            return num;
        }
        long result = 0L, temp = num, rem;
        int i = 0, j = 0, len = 0;
        while (temp != 0) {
            temp /= 10;
            len++;
        }
        temp = num < 0 ? num * -1 : num;
        Long[] digits = new Long[len];
        while (temp != 0) {
            rem = temp % 10;
            temp /= 10;
            digits[i++] = rem;
        }
        if (num < 0) {
            Arrays.sort(digits, Collections.reverseOrder());
        } else {
            Arrays.sort(digits);
            if (digits[0] == 0L) {
                while (digits[j] == 0L) {
                    j++;
                }
                digits[0] = digits[j];
                digits[j] = 0L;
            }
        }
        j = 0;
        for (i = len - 1; i > -1; i--) {
            result += (long) Math.pow(10, j++) * digits[i];
        }
        return num > -1 ? result : result * -1;
    }
}
