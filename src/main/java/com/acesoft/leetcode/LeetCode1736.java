package com.acesoft.leetcode;

import java.lang.Integer;

/*
 * https://leetcode.com/problems/latest-time-by-replacing-hidden-digits
 * 
 * You are given a string time in the form of hh:mm, where some of the digits in the string are hidden
 * (represented by ?).
 * 
 * The valid times are those inclusively between 00:00 and 23:59.
 * 
 * Return the latest valid time you can get from time by replacing the hidden digits. 
 * 
 * Example 1:
 * Input: time = "2?:?0"
 * Output: "23:50"
 * Explanation: The latest hour beginning with the digit '2' is 23 and the latest minute ending with
 * the digit '0' is 50.
 * 
 * Example 2:
 * Input: time = "0?:3?"
 * Output: "09:39"
 * 
 * Example 3:
 * Input: time = "1?:22"
 * Output: "19:22"
 * 
 * Constraints:
 * time is in the format hh:mm.
 * It is guaranteed that you can produce a valid time from the given string.
 */
public class LeetCode1736 {
    public String maximumTime(String time) {
        char[] timeC = time.toCharArray();
        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            timeC[0] = '2';
            timeC[1] = '3';
        } else if (time.charAt(0) == '?') {
            timeC[0] = Integer.parseInt(String.valueOf(time.charAt(1))) < 4 ? '2' : '1';
        } else if (time.charAt(1) == '?') {
            timeC[1] = Integer.parseInt(String.valueOf(time.charAt(0))) < 2 ? '9' : '3';
        }
        if (time.charAt(3) == '?') {
            timeC[3] = '5';
        }
        if (time.charAt(4) == '?') {
            timeC[4] = '9';
        }
        return String.valueOf(timeC);
    }
}