package com.acesoft.model;

public class ListNode {

  ListNode next;
  int val;

  public ListNode(int x) {
    val = x;
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }
}
