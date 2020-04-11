package com.acesoft.leetcode;

import com.acesoft.model.ListNode;

/*
 *  https://leetcode.com/problems/merge-two-sorted-lists
 *
 *  Merge two sorted linked lists and return it as a new list. The new list should be made by
 *  splicing together the nodes of the first two lists.
 *
 *  Example:
 *  Input: 1->2->4, 1->3->4
 *  Output: 1->1->2->3->4->4
 */
public class LeetCode21 {

    // Iterative solution
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sorted = new ListNode(0);
        ListNode pointer = sorted;
        while (l1 != null && l2 != null) {
            if (l1.getVal() <= l2.getVal()) {
                pointer.setNext(l1);
                l1 = l1.getNext();
            } else {
                pointer.setNext(l2);
                l2 = l2.getNext();
            }
            pointer = pointer.getNext();
        }
        if (l1 != null) {
            pointer.setNext(l1);
        }
        if (l2 != null) {
            pointer.setNext(l2);
        }
        return sorted.getNext();
    }
    
    // Recursive solution
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null ) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode pointer = null;
        if (l1.getVal() <= l2.getVal()) {
            pointer = l1;
            pointer.setNext(mergeTwoLists2(l1.getNext(), l2));
        } else {
            pointer = l2;
            pointer.setNext(mergeTwoLists2(l1, l2.getNext()));
        }
        return pointer;
    }
}