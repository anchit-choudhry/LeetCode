package com.acesoft.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 *  https://leetcode.com/problems/fizz-buzz
 *
 *  Write a program that outputs the string representation of numbers from 1 to n.
 *
 *  But for multiples of three it should output “Fizz” instead of the number and for the multiples
 *  of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 *  Example:
 *  n = 15,
 *  Return:
 *  [
 *      "1",
 *      "2",
 *      "Fizz",
 *      "4",
 *      "Buzz",
 *      "Fizz",
 *      "7",
 *      "8",
 *      "Fizz",
 *      "Buzz",
 *      "11",
 *      "Fizz",
 *      "13",
 *      "14",
 *      "FizzBuzz"
 *  ]
 */
public class LeetCode412 {

  public List<String> fizzBuzz(int n) {
    int i;
    List<String> ret = new ArrayList<>();
    for (i = 1; i <= n; i++) {
      ret.add(i % 3 != 0 && i % 5 != 0 ? String.valueOf(i)
          : (i % 3 == 0 ? "Fizz" : "") + (i % 5 == 0 ? "Buzz" : ""));
    }
    return ret;
  }
}