package com.acesoft.leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *  https://leetcode.com/problems/number-of-days-between-two-dates
 *
 *  Write a program to count the number of days between two dates.
 *
 *  The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.
 *
 *  Example 1:
 *  Input: date1 = "2019-06-29", date2 = "2019-06-30"
 *  Output: 1
 *
 *  Example 2:
 *  Input: date1 = "2020-01-15", date2 = "2019-12-31"
 *  Output: 15
 */
public class LeetCode1360 {

  // Suboptimal solution using built-in libraries
  public int daysBetweenDates(String date1, String date2) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d1, d2;
    try {
      d1 = sdf.parse(date1);
      d2 = sdf.parse(date2);
    } catch (ParseException exp) {
      return 0;
    }
    long diff = (d2.getTime() - d1.getTime()) / 86_400_000;
    return (int) (diff < 0 ? diff * -1 : diff);
  }
}