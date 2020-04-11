package com.acesoft.leetcode;

/*
 *  https://leetcode.com/problems/min-stack
 *
 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *  push(x) -- Push element x onto stack.
 *  pop() -- Removes the element on top of the stack.
 *  top() -- Get the top element.
 *  getMin() -- Retrieve the minimum element in the stack.
 * 
 *
 *  Example:
 *
 *  MinStack minStack = new MinStack();
 *  minStack.push(-2);
 *  minStack.push(0);
 *  minStack.push(-3);
 *  minStack.getMin();   --> Returns -3.
 *  minStack.pop();
 *  minStack.top();      --> Returns 0.
 *  minStack.getMin();   --> Returns -2.
 *
 *  Your MinStack object will be instantiated and called as such:
 *  MinStack obj = new MinStack();
 *  obj.push(x);
 *  obj.pop();
 *  int param_3 = obj.top();
 *  int param_4 = obj.getMin();
 */
public class LeetCode155 {
}

class MinStack {

    private class Node {
        int min;
        Node next;
        int val;

        public Node(int v, int m) {
            this(v, m, null);
        }

        public Node(int v, int m, Node n) {
            val = v;
            min = m;
            next = n;
        }
    }

    private Node head;

    // initialize your data structure here
    public MinStack() {
    }

    public int getMin() {
        return head.min;
    }

    public void pop() {
        head = head.next;
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, x < head.min ? x : head.min, head);
        }
    }

    public int top() {
        return head.val;
    }
}