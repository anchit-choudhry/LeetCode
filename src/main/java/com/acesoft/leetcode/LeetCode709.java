package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/to-lower-case
 *
 *  Implement function ToLowerCase() that has a string parameter str, and returns the same string
 *  in lowercase.
 *
 *  Example 1:
 *
 *  Input: "Hello"
 *  Output: "hello"
 *  Example 2:
 *
 *  Input: "here"
 *  Output: "here"
 *  Example 3:
 *
 *  Input: "LOVELY"
 *  Output: "lovely"
 */
public class LeetCode709 {

    public String toLowerCase(String str) {
        if (str.length() < 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(ch > 64 && ch < 91 ? (char) (ch + 32) : ch);
        }
        return sb.toString();
    }
}