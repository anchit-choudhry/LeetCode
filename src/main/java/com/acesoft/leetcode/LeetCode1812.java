package com.acesoft.leetcode;

/*
 * https://leetcode.com/problems/determine-color-of-a-chessboard-square
 * 
 * You are given coordinates, a string that represents the coordinates of a square of the chessboard.
 * Below is a chessboard for your reference.
 * 
 * Return true if the square is white, and false if the square is black.
 * 
 * The coordinate will always represent a valid chessboard square. The coordinate will always have
 * the letter first, and the number second.
 * 
 * Example 1:
 * Input: coordinates = "a1"
 * Output: false
 * Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.
 * 
 * Example 2:
 * Input: coordinates = "h3"
 * Output: true
 * Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.
 * 
 * Example 3:
 * Input: coordinates = "c7"
 * Output: false
 * 
 * Constraints:
 * coordinates.length == 2
 * 'a' <= coordinates[0] <= 'h'
 * '1' <= coordinates[1] <= '8'
 */
public class LeetCode1812 {

    public boolean squareIsWhite(String coordinates) {
        int cor1 = coordinates.charAt(0) - 96;
        int cor2 = coordinates.charAt(1) - 48;
        return !((cor1 % 2 == 1 && cor2 % 2 == 1) || (cor1 % 2 == 0 && cor2 % 2 == 0));
    }
}