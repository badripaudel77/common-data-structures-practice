package com.cs.dsa.linkedlist;

/*
 * Doubly Linked List Version 2 : has a node which also contains prev to track the previous element
 */

/**
 * Node in a DLL is going to have, next and prev node, and data field to hold the value of Node.
 */
class DLLNode {
    DLLNode prev, next;
    int info;

    public DLLNode() {
        this.prev = null;
        this.next = null;
    }
    public DLLNode(int info) {
        this.info = info;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    DLLNode head;
    DLLNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public DLLNode getFirstElement() {
        DLLNode firstNode =  this.head != null ? this.head: null;
        return firstNode;
    }

    public void addToHead(int element) {
        DLLNode newNode = new DLLNode(element);
        if(this.head == null) {
            head = tail = newNode;
        }
        // head is not null
        else {
            head.prev = newNode;
            head.prev.next = head;
            head = newNode;
            head.prev = null;
        }
    }

    public void addToTail(int value) {
        DLLNode newNode = new DLLNode(value);
        if(head == null) {
            head = tail = newNode;
            head.prev = tail.prev = null;
        }
        else {
            tail.next = newNode;
            tail.next.prev = tail;
            tail = newNode;
        }
    }

    public DLLNode removeFromHead() {
        if(head == null || tail == null) {
            return null;
        }
        DLLNode temp = head;
        if(head == tail) {
            head = tail = null;
            return temp;
        }
        else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        return temp;
    }

    public DLLNode removeFromTail() {
        if(head == null || tail == null) {
            return null;
        }
        DLLNode temp = tail;
        // only one Node
        if(head == tail) {
            head = tail = null;
            return temp;
        }
        // more than one Node
        else {
            tail = tail.prev;
            tail.next = null;
        }
        return temp;
    }

    /**
     * @param index
     * Get the node at index. In DLL, we can traverse both forward and backward. If we have maintained ref to length item, we could determine
     * where to begin (backward or forward traversal). If lies in the first half, start from head else from tail.
     * In this case, I have not maintained length, I have to determine the size first and then do as above or implement in a single pass.
     */
    public DLLNode getNodeByIndex(int index) {
        if(index < 0) {
            return null;
        }
        int count = 0; // 0 meaning first node
        DLLNode temp = head;
        while(temp != null) {
            if(index == count) {
                System.out.println("Node with info " + temp.info + " found at index " + index);
                return temp;
            }
            count++;
            temp = temp.next;
        }
        // index doesn't exist.
        return null;
    }

    // remove node at index
    public DLLNode removeNodeAtIndex(int index) {
        DLLNode node = getNodeByIndex(index);
        DLLNode temp = node;
        if(node == null) {
            return null;
        }
        // if one and only element
        if(head == tail) {
            head = tail = null;
            return temp;
        }
        // check if it has no next node, remove from tail
        if(node.next == null) {
            DLLNode tailNode = removeFromTail();
            return tailNode;
        }
        else if(node.prev == null) {
            return removeFromHead();
        }
        else {
            DLLNode prev = node.prev;
            DLLNode next = node.next;
            prev.next = next;
            next.prev = prev;
            node.next = node.prev = null;
        }
        return temp;
    }

    @Override
    public String toString() {
        return "(To String method) Head has info : " + head.info +  " and tail is pointing to : " + tail.info;
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        DLLNode firstElement = doublyLinkedList.getFirstElement();
        System.out.println("First element = " + firstElement);
        boolean isEmpty = doublyLinkedList.isEmpty();
        System.out.println("Is list empty ? " + isEmpty);

        doublyLinkedList.addToHead(10);
        System.out.println("is it empty after adding ? " + doublyLinkedList.isEmpty()  + " first element now is: " + doublyLinkedList.getFirstElement().info);
        doublyLinkedList.addToTail(20);
        System.out.println(doublyLinkedList);
        doublyLinkedList.removeFromTail();
        System.out.println(doublyLinkedList);
        doublyLinkedList.addToTail(50);
        doublyLinkedList.removeFromHead();
        System.out.println(doublyLinkedList);
        doublyLinkedList.getNodeByIndex(10);
        doublyLinkedList.addToTail(34);
        doublyLinkedList.addToHead(90);
        doublyLinkedList.getNodeByIndex(2);
        doublyLinkedList.removeNodeAtIndex(1);
        System.out.println(doublyLinkedList);
    }
}