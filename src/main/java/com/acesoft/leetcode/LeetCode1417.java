package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/reformat-the-string
 *
 *  Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English
 *  letters and digits).
 *
 *  You have to find a permutation of the string where no letter is followed by another letter and
 *  no digit is followed by another digit. That is, no two adjacent characters have the same type.
 *
 *  Return the reformatted string or return an empty string if it is impossible to reformat the string.
 *
 *  Example 1:
 *  Input: s = "a0b1c2"
 *  Output: "0a1b2c"
 *  Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c",
 *  "0c2a1b" are also valid permutations.
 *
 *  Example 2:
 *  Input: s = "leetcode"
 *  Output: ""
 *  Explanation: "leetcode" has only characters so we cannot separate them by digits.
 *
 *  Example 3:
 *  Input: s = "1229857369"
 *  Output: ""
 *  Explanation: "1229857369" has only digits so we cannot separate them by characters.
 *
 *  Example 4:
 *  Input: s = "covid2019"
 *  Output: "c2o0v1i9d"
 *
 *  Example 5:
 *  Input: s = "ab123"
 *  Output: "1a2b3"
 * 
 *  Constraints:
 *  1 <= s.length <= 500
 *  s consists of only lowercase English letters and/or digits.
 */
public class LeetCode1417 {

    // Suboptimal solution
    public String reformat(String s) {
        int nums = 0, chars = 0, ascii, i = 0, j = 0, k = 0;
        char[] cArr = new char[s.length()];
        char[] nArr = new char[s.length()];
        StringBuilder newString = new StringBuilder();
        for (char ch : s.toCharArray()) {
            ascii = ch;
            if (ascii > 47 && ascii < 58) {
                nums++;
                nArr[i++] = ch;
            } else {
                chars++;
                cArr[j++] = ch;
            }
        }
        i = j = 0;
        if (nums == chars || nums - chars == -1 || nums - chars == 1) {
            for (k = 0; k < s.length(); k++) {
                if (k % 2 == 0) {
                    if (nums - chars >= 0) {
                        if (nArr[i] == 0) {
                            return "";
                        }
                        newString.append(nArr[i++]);
                    } else {
                        if (cArr[j] == 0) {
                            return "";
                        }
                        newString.append(cArr[j++]);
                    }
                } else {
                    if (nums - chars < 0) {
                        if (nArr[i] == 0) {
                            return "";
                        }
                        newString.append(nArr[i++]);
                    } else {
                        if (cArr[j] == 0) {
                            return "";
                        }
                        newString.append(cArr[j++]);
                    }
                }
            }
            return newString.toString();
        }
        return "";
    }
}