package com.example.dataStructures;

public class MyQueue {

    public static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head; // remove from the head
    private Node tail; // add to the tail

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        return head.data;
    }

    // add to the tail
    public void add(int data) {
        Node node = new Node(data);
        if (tail != null) {
            tail.next = node;
        } else {
            tail = node;
        }

        if (head == null) {
            head = node;
        }
    }

    // remove from the head
    public int remove() {
        int result = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return result;
    }

}
