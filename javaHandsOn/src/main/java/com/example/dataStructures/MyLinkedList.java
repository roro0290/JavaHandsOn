package com.example.dataStructures;

public class MyLinkedList {

    private SinglyListNode head = null;

    static class SinglyListNode {
        int val;
        SinglyListNode next;

        SinglyListNode(int val) {
            this.val = val;
            // by default next will point to null
        }
    }

    public MyLinkedList() {

    }

    public int get(int index) {
        SinglyListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node!=null ? node.val : -1;
    }

    public void addAtHead(int val) {
        head = new SinglyListNode(val);
    }

    public void addAtTail(int val) {
        // create a new node
        SinglyListNode node = new SinglyListNode(val);

        // first refers to a head
        SinglyListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;

    }

    public void addAtIndex(int index, int val) {

        if (index < 0)
            return;

        SinglyListNode newNode = new SinglyListNode(val);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            SinglyListNode current = head;
            for (int i = 0; i < index - 1 && current != null; i++) {
                current = current.next;
            }
            if(current!=null){
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    public void deleteAtIndex(int index) {

        if(index < 0 || head == null)
            return;

        if(index==0){
            head = head.next;
        }else{
            SinglyListNode current = head;
            for(int i=1;i<index;i++){
                current = current.next;
            }

            if(current != null && current.next !=null){
                current.next = current.next.next;
            }
        }
    }

}
