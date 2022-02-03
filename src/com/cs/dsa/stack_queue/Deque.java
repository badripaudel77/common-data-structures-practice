package com.cs.dsa.stack_queue;

/*

Deque or Double Ended Queue is a type of queue in which insertion and removal of elements can be performed
from either from the front or rear.
Thus,it does not follow FIFO rule (First In First Out).

operations :
            - Add from the front, Add from the back,
            - Remove from the front, Remove from the back,
            - get front and get back,
            - isEmpty and isFull

Docs : https://www.javatpoint.com/ds-deque
*/

public class Deque {
    int[] arr;
    int size;
    int front, rear;

    // Create the Deque of given size
    public Deque(int size) {
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
        this.size = size;
    }

    //insert from the front side
    private void insertFront(int item) {
        //System.out.println(arr[0]);
        if (isFull()) {
            System.out.println("Queue is already full.");
            return;
        }
        //if first time insertion
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        }
        // Front at first pos
        else if (front == 0) {
            front = size - 1;
        } else {
            front--;
        }
        arr[front] = item;
        System.out.println("Item = " + item + " Added successfully from the front side..");
    }

    //insert from the back side
    private void insertBack(int item) {
        if (isFull()) {
            System.out.println("Queue is already full.");
            return;
        }

        //if first time insertion
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        if (rear == size - 1) {
            rear = 0; //implementation of circular queue
        } else {
            rear++;
        }
        arr[rear] = item;
        System.out.println("Item = " + item + " Added successfully from the back side..");
    }

    //remove from the front side
    private void deleteFront() {
        if (isEmpty()) {
            System.out.println("Queue is already empty.");
            return;
        }
        //if only one item.
        if (front == 0 && rear == 0) {
            front = -1;
            rear = -1;
        }
        //If front points to the last element in a queue
        else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
        System.out.println("Item deleted successfully from the front.");
    }

    //remove from the back side
    private void deleteRear() {
        if (isEmpty()) {
            System.out.println("Queue is already empty.");
            return;
        }
        //if only one item.
        if (front == 0 && rear == 0) {
            front = -1;
            rear = -1;
        }
        //If front points to the last element in a queue
        else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
        System.out.println("Item  deleted successfully from the back.");
    }

    private boolean isEmpty() {
        return front == -1;
    }

    private boolean isFull() {
        if (front == 0 && rear == size - 1 || (front == rear + 1)) return true;
        return false;
    }

    public void getFront() {
        if (front == -1) {
            System.out.println("There is no element found.");
            return;
        }
        if (isEmpty()) {
            System.out.println("No element found.");
            return;
        }
        System.out.println("Front element of the queue is : " + arr[front]);
    }

    public void getRear() {
        if (rear == -1) {
            System.out.println("There is no element found.");
            return;
        }
        if (isEmpty()) {
            System.out.println("No element found.");
            return;
        }
        System.out.println("Rear element of the queue is : " + arr[rear]);
    }

    public void display() {
        int i = front;
        System.out.print("\nElements are : ");
        while (i != rear) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % size;
        }
        System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Deque deque = new Deque(5);

        deque.insertFront(15);
        deque.insertFront(16);
        deque.insertFront(26);
        deque.insertFront(36);
        //  deque.insertFront(46);

        deque.display();
        deque.insertBack(66);
        deque.display();

        deque.getFront();
        deque.getRear();
        deque.display();
        deque.deleteRear();
        deque.display();
        deque.deleteFront();
        deque.display();
        deque.getRear();
    }
}
