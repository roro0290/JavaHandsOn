package com.example.dataStructures;

public class MyStack {

    private static class Node {
        int data;
        Node next; // refers to the node that it is on top of

        Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    private boolean isEmpty() {
        return top == null;
    }

    private int peek() {
        return top.data;
    }

    // put data on the top
    public void push(int data) {
        Node node = new Node(data);
        if (top != null) {
            node.next = top;
        }
        top = node;
    }

    // remove the top most data
    public int top() {

        int num = top.data;
        top = top.next;
        return num;
    }

}
