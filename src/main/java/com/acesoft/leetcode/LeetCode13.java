package com.acesoft.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode13 {

    // Suboptimal solution
    public int romanToInt(String s) {
        Map<String, Integer> sToV = new HashMap<String, Integer>() {
            private static final long serialVersionUID = 1L;
            {
                put("I", 1);
                put("V", 5);
                put("X", 10);
                put("L", 50);
                put("C", 100);
                put("D", 500);
                put("M", 1000);
                put("IV", 4);
                put("IX", 9);
                put("XL", 40);
                put("XC", 90);
                put("CD", 400);
                put("CM", 900);
            }
        };
        int i, number = 0;
        for (i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && sToV.containsKey(s.substring(i, i + 2))) {
                number += sToV.get(s.substring(i, i + 2));
                i++;
                continue;
            }
            number += sToV.get(Character.toString(s.charAt(i)));
        }
        return number;
    }
}