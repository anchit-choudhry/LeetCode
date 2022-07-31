package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case
 *
 *  Given a string of English letters s, return the greatest English letter which occurs as both a
 *  lowercase and uppercase letter in s. The returned letter should be in uppercase.
 *  If no such letter exists, return an empty string.
 *
 *  An English letter b is greater than another letter a if b appears after a in the English
 *  alphabet.
 *
 *  Example 1:
 *  Input: s = "lEeTcOdE"
 *  Output: "E"
 *  Explanation:
 *  The letter 'E' is the only letter to appear in both lower and upper case.
 *
 *  Example 2:
 *  Input: s = "arRAzFif"
 *  Output: "R"
 *  Explanation:
 *  The letter 'R' is the greatest letter to appear in both lower and upper case.
 *  Note that 'A' and 'F' also appear in both lower and upper case, but 'R' is greater than
 *  'F' or 'A'.
 *
 *  Example 3:
 *  Input: s = "AbCdEfGhIjK"
 *  Output: ""
 *  Explanation:
 *  There is no letter that appears in both lower and upper case.
 *
 *  Constraints:
 *  1 <= s.length <= 1000
 *  s consists of lowercase and uppercase English letters.
 */
public class LeetCode2309 {

    public String greatestLetter(String s) {
        int temp;
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (char ch : s.toCharArray()) {
            temp = ch - 'a';
            if (temp > -1) {
                lower[temp] = 1;
            } else {
                upper[temp + 32] = 1;
            }
        }
        for (temp = 25; temp > -1; temp--) {
            if (lower[temp] == 1 && upper[temp] == 1) {
                return Character.toString(65 + temp);
            }
        }
        return "";
    }
}
