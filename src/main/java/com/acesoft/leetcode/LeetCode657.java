package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/judge-route-circle
 *
 *  Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this
 *  robot makes a circle, which means it moves back to the original place.
 *
 *  The move sequence is represented by a string. And each move is represent by a character. The
 *  valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or
 *  false representing whether the robot makes a circle.
 *
 *  Example 1:
 *  Input: "UD"
 *  Output: true
 *
 *  Example 2:
 *  Input: "LL"
 *  Output: false
 */
public class LeetCode657 {

    enum move {
        D, L, R, U
    }

    /* Naive solution */
    public boolean judgeCircle(String moves) {
        int[] doneMoves = new int[4];
        for (int i = 0; i < moves.length(); i++) {
            doneMoves[move.valueOf(String.valueOf(moves.charAt(i))).ordinal()] += 1;
        }
        return doneMoves[0] == doneMoves[1] && doneMoves[2] == doneMoves[3];
    }

    /* Better solution with less Space complexity */
    public boolean judgeCircle1(String moves) {
        int count = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    count += 2;
                    break;
                case 'D':
                    count -= 2;
                    break;
                case 'L':
                    count++;
                    break;
                case 'R':
                    count--;
                    break;
            }
        }
        return count == 0;
    }
}