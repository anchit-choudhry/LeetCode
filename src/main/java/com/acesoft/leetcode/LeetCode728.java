package com.acesoft.leetcode;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/self-dividing-numbers
 * 
 * A self-dividing number is a number that is divisible by every digit it contains.
 * 
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * 
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * 
 * Given a lower and upper number bound, output a list of every possible self dividing number,
 * including the bounds if possible.
 * 
 * Example 1:
 * Input: 
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 
 * Note:
 * The boundaries of each input argument are 1 <= left <= right <= 10000
 */
public class LeetCode728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        IntPredicate isSelfDiv = n -> {
            int temp = n, rem;
            while (temp != 0) {
                rem = temp % 10;
                if (rem == 0 || n % rem != 0) {
                    return false;
                }
                temp /= 10;
            }
            return true;
        };
        return IntStream.rangeClosed(left, right).filter(isSelfDiv).boxed().collect(Collectors.toList());
    }
}