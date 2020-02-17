package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/score-after-flipping-matrix
 *
 *  We have a two dimensional matrix A where each value is 0 or 1.
 *
 *  A move consists of choosing any row or column, and toggling each value in that row or column:
 *  Changing all 0s to 1s, and all 1s to 0s.
 *
 *  After making any number of moves, every row of this matrix is interpreted as a binary number,
 *  and the score of the matrix is the sum of these numbers.
 *
 *  Return the highest possible score.
 *
 *  Example 1:
 *
 *  Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 *  Output: 39
 *
 *  Explanation:
 *
 *  Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
 *  0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 *  Note:
 *
 *  1 <= A.length <= 20
 *  1 <= A[0].length <= 20
 *  A[i][j] is 0 or 1
 */
public class LeetCode861 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        new LeetCode861().matrixScore(matrix);
    }

    public int matrixScore(int[][] A) {
        if (A.length < 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                continue;
            }
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = A[i][j] == 0 ? 1 : 0;
            }
        }
        for (int[] ints : A) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        return sum;
    }
}