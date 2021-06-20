package com.acesoft.leetcode;

import com.acesoft.model.ListNode;

/*
 *  https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer
 *
 *  Given head which is a reference node to a singly-linked list. The value of each node in the
 *  linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 *  Return the decimal value of the number in the linked list.
 *
 *  Example 1:
 *  Input: head = [1,0,1]
 *  Output: 5
 *  Explanation: (101) in base 2 = (5) in base 10
 *
 *  Example 2:
 *  Input: head = [0]
 *  Output: 0
 *
 *  Example 3:
 *  Input: head = [1]
 *  Output: 1
 *
 *  Example 4:
 *  Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 *  Output: 18880
 *
 *  Example 5:
 *  Input: head = [0,0]
 *  Output: 0
 *
 *  Constraints:
 *  The Linked List is not empty.
 *  Number of nodes will not exceed 30.
 *  Each node's value is either 0 or 1.
 */
public class LeetCode1290 {

    // Optimal solution using Bitwise Left Shift
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = (sum << 1) | head.getVal();
            head = head.getNext();
        }
        return sum;
    }

    // Suboptimal solution
    public int getDecimalValue1(ListNode head) {
        int count = 1, i = 1, sum = 0;
        ListNode tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            count++;
        }
        tmp = head;
        while (tmp != null) {
            sum += tmp.getVal() * (int) Math.pow(2, count - i);
            i++;
            tmp = tmp.getNext();
        }
        return sum;
    }
}