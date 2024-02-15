package com.example.leetcode.medium.stack;

import java.util.Stack;

/*
Leetcode: 143 Reorder list
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 */
public class ReorderList {

    // the list node only has NEXT, not previous
    // number of nodes in the range: [1, 5 * 10^4].
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
            return ;

        Stack<ListNode> stack = new Stack<>();

        ListNode temp = head;

        // traverse once and put all the nodes into a stack
        // we put it all into a stack because we want to access the last node in the list and go backwards from there
        do {
            stack.add(temp);
            temp = temp.next;
        } while (temp != null);

        ListNode L = head, R = head.next;

        // R == null is the situation where there is only 1 element
        // if this condition is wrong, it will throw a empty stack exception cause it will keep going in and pop everything out
        // another approach is since we know the middle value (e.g. if there are 4 elements, only need to loop 4/2 -1 times
        // so you can loop using a count variable instead
        while (stack.peek()!=L && stack.peek()!=R) {
            ListNode node = stack.pop();
            node.next = R;
            L.next = node;
            L = R; // L becomes the previous R
            R = R.next; // shift R by one spot
        }

        ListNode last = stack.pop();
        last.next = null;

    }

}
