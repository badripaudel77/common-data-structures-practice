package com.cs.dsa.stack_queue;

// Queue implementation using LinkedList (FIFO)
// 1.Add (a.k.a. enqueue ) from the back
// 2. Remove (a.k.a. dequeue ) from the front (Like in a regular queue of humans on a shop or so)

public class QueueV2 {
    Node front;
    Node back;
    int size;

    public QueueV2(int data) {
        Node node = new Node(data);
        this.front = node;
        this.back = node;
        this.size = 1;
        System.out.println("Node with value: " + data + " added to the queue.");
    }

    class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add to the queue (to the back)
    public Node enqueue(int data) {
        Node node = new Node(data);
        if (size < 1) {
            this.back = node;
            this.front = node;
        } else {
            back.next = node;
            back = node;
        }
        System.out.println("Node with item : " + node.data + " added to the queue.");
        this.size++;
        return node;
    }

    // Remove from the queue (the item added first to the queue will be removed first (from the front)
    public Node dequeue() {
        if (size == 0) {
            return null;
        }
        Node temp = front;
        if (size == 1) {
            front = back = null;
        } else {
            front = front.next;
            temp.next = null;
        }
        this.size--;
        System.out.println("Node with item : " + temp.data + " removed from the queue.");
        return temp;
    }

    public Node getFront() {
        return front;
    }

    public Node getBack() {
        return back;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        QueueV2 queue = new QueueV2(10);

        queue.enqueue(20);
        queue.enqueue(30);

        queue.dequeue();
        System.out.println(queue);
    }
}
