package com.acesoft.leetcode;

import com.acesoft.model.ListNode;

/*
 * https://leetcode.com/problems/middle-of-the-linked-list
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 *
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Note:
 * The number of nodes in the given list will be between 1 and 100.
 */
public class LeetCode876 {

  // Naive approach
  public ListNode middleNode(ListNode head) {
    int i = 0, middle;
    ListNode tmp = head;
    while (tmp.getNext() != null) {
      tmp = tmp.getNext();
      i++;
    }
    middle = (i / 2) + i % 2;
    i = 0;
    while (i < middle) {
      head = head.getNext();
      i++;
    }
    return head;
  }

  // Using slow and fast pointer
  public ListNode middleNode1(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.getNext() != null) {
      slow = slow.getNext();
      fast = slow.getNext().getNext();
    }
    return slow;
  }
}
