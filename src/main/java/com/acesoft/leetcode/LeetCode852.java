package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/peak-index-in-a-mountain-array
 *
 *  Let's call an array A a mountain if the following properties hold:
 *
 *  A.length >= 3
 *  There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 *  Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 *
 *  Example 1:
 *  Input: [0,1,0]
 *  Output: 1
 *
 *  Example 2:
 *  Input: [0,2,1,0]
 *  Output: 1
 *
 *  Note:
 *  3 <= A.length <= 10000
 *  0 <= A[i] <= 10^6
 *  A is a mountain, as defined above.
 */
public class LeetCode852 {

  private boolean checkAllElemsLess(int[] A, int start, int stop, int num) {
    if (start < 0 || start >= stop) {
      return true;
    }
    for (int i = start; i < stop; i++) {
      if (A[i] > num) {
        return false;
      }
    }
    return true;
  }

  // Naive solution
  public int peakIndexInMountainArray(int[] A) {
    for (int i = 0; i < A.length; i++) {
      if (checkAllElemsLess(A, i - 1, i, A[i])
          && checkAllElemsLess(A, i + 1, A.length, A[i])) {
        return i;
      }
    }
    return -1;
  }

  // Optimal solution using O(N)
  public int peakIndexInMountainArray1(int[] A) {
    int i = 0;
    while (A[i] < A[i + 1]) {
      i++;
    }
    return i;
  }

  // Most optimal solution using Binary Search O(log N)
  public int peakIndexInMountainArray2(int[] A) {
    int low = 0, mid, high = A.length - 1;
    while (low < high) {
      mid = low + (high - low) / 2;
      if (A[mid] < A[mid + 1]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }
}
