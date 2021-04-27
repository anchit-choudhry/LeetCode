package com.acesoft.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/merge-intervals
 * 
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input. 
 * 
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        int i = 0;
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        merged.add(intervals[0]);
        for (int[] interval : intervals) {
            int[] temp = merged.get(merged.size() - 1);
            if (temp[1] >= interval[0]) {
                if (temp[1] >= interval[1]) {
                    continue;
                } else {
                    merged.remove(merged.size() - 1);
                    merged.add(new int[] { temp[0], interval[1] });
                }
            } else {
                merged.add(interval);
            }
        }
        int[][] result = new int[merged.size()][2];
        for (int[] arr : merged) {
            result[i++] = arr;
        }
        return result;
    }
}