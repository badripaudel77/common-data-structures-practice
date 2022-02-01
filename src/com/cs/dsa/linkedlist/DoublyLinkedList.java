package com.cs.dsa.linkedlist;

/*
 * Doubly Linked List : has a node which also contains prev to track the previous element
 */

public class DoublyLinkedList {
    Node head;
    /*
     * DLL has Node
     * Node has Previous Node, Next Node and Data
     */

    class Node {
        Node prev, next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    // add at the front
    void pushAtFront(int data) {
        // create the node
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;

        if(head!= null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    // add at back
    void addAtRear(int data) {
        Node newNode = new Node(data);
        Node lastNode = head;

        // if we're trying to add at the end of empty list
        if(head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }
        while (lastNode.next!=null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        newNode.prev = lastNode;
    }

    // traverse forward direction
    void traverseFromForward() {
        Node tempNode = head;
        System.out.print("Printing from forward direction : ");
        while (tempNode!= null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.pushAtFront(15);
        doublyLinkedList.pushAtFront(35);
        doublyLinkedList.pushAtFront(5);
        doublyLinkedList.addAtRear(25);
        doublyLinkedList.addAtRear(55);
        doublyLinkedList.traverseFromForward();
    }

}