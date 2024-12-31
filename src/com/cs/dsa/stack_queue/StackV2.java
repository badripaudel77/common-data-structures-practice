package com.cs.dsa.stack_queue;

// Stack using the Linked List (Node inner class)
public class StackV2 {
    Node top;
    int height;

    public StackV2(int value) {
        this.height = 1;
        Node node = new Node(value);
        this.top = node;
    }
    // Inner class to represent each Item (Node) of the stack.
    class Node {
        int data;
        Node next;

        public Node (int data) {
            this.data = data;
            next = null;
        }
    }

    public void push(int data) {
        Node node = new Node(data);
        if(top == null) {
            top = node;
        }
        else {
            Node temp = top;
            top = node;
            top.next = temp;
        }
        height++;
        System.out.println("Item " + data + " has been pushed to stack");
    }

    public void pop() {
        if(top == null) {
            System.out.println("Stack is empty ");
            return;
        }
        else {
            Node temp = top;
            top = top.next;
            temp.next = null;
            height--;
            System.out.println("Item " + temp.data + " removed from the stack.");
        }
    }
    public Node getTop() {
        System.out.println("Top has value: " + top.data);
        return this.top;
    }

    public int getHeight() {
        System.out.println("Height of the stack : " + this.height);
        return this.height;
    }

    public void printStack() {
        Node current = top;
        System.out.print("Printing the stack : ");
        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackV2 stack = new StackV2(10);

        stack.printStack();
        stack.getHeight();
        stack.getTop();

        stack.push(20);
        stack.push(30);

        stack.printStack();
        stack.getTop();
        stack.getHeight();

        stack.pop();
        stack.getHeight();
        stack.getTop();
    }
}
