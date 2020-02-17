package com.acesoft.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 *  https://leetcode.com/problems/maximum-69-number
 *
 *  Given a positive integer num consisting only of digits 6 and 9.
 *
 *  Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 *
 *  Example 1:
 *
 *  Input: num = 9669
 *  Output: 9969
 *  Explanation: 
 *  Changing the first digit results in 6669.
 *  Changing the second digit results in 9969.
 *  Changing the third digit results in 9699.
 *  Changing the fourth digit results in 9666. 
 *  The maximum number is 9969.
 *  Example 2:
 *
 *  Input: num = 9996
 *  Output: 9999
 *  Explanation: Changing the last digit 6 to 9 results in the maximum number.
 *  Example 3:
 *
 *  Input: num = 9999
 *  Output: 9999
 *  Explanation: It is better not to apply any change.
 * 
 *
 *  Constraints:
 *
 *  1 <= num <= 10^4
 *  num's digits are 6 or 9.
 */
public class Leetcode1323 {

    public int maximum69Number(int num) {
        int maxNum = num, i = 0, pos = -1;
        while (maxNum > 0) {
            if (maxNum % 10 == 6) {
                pos = i;
            }
            maxNum /= 10;
            i++;
        }
        return pos > -1 ? 3 * (int) Math.pow(10, pos) + num : num;
    }

    // Dumbest solution
    public int maximum69Number1(int num) {
        Map<Integer, Integer> hs = new HashMap<Integer, Integer>() {
            private static final long serialVersionUID = 1L;
            {
                put(6, 9);
                put(9, 9);
                put(66, 96);
                put(69, 99);
                put(96, 99);
                put(99, 99);
                put(666, 966);
                put(669, 969);
                put(696, 996);
                put(699, 999);
                put(966, 996);
                put(969, 999);
                put(996, 999);
                put(999, 999);
                put(6666, 9666);
                put(6669, 9669);
                put(6696, 9696);
                put(6699, 9699);
                put(6966, 9966);
                put(6969, 9969);
                put(6996, 9996);
                put(6999, 9999);
                put(9666, 9966);
                put(9669, 9969);
                put(9696, 9996);
                put(9699, 9999);
                put(9966, 9996);
                put(9969, 9999);
                put(9996, 9999);
                put(9999, 9999);
            }
        };
        return hs.get(num);
    }
}
