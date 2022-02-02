package com.cs.dsa.stack_queue;

/*
  Front side is called "front" and back side is "rear"

  Defn: Circular Queue is also a linear data structure, which follows the principle of FIFO(First In First Out),
        but instead of ending the queue at the last position, it again starts from the first position after the last,
        hence making the queue behave like a circular data structure.

     Circular Queue works by the process of circular increment
     i.e. when we try to increment the pointer and we reach the end of the queue,
     we start from the beginning of the queue.

 - Initially when the queue is empty, both are pointing to the same location.

 - Increase "rear" while doing "enqueue operation" and increase "front" while doing "dequeue operation".

 - Data is added to the location that is pointed by rear and deleted from the location that is pointed by front.

*/

import java.util.Arrays;
import java.util.stream.IntStream;

/*
Queue of size 4
initially R = F = -1
on first insertion F=R=0
elements[rear] = element, R++
Rear             Front
---------------------
-    -    -    -    -
---------------------

 */
public class CircularQueue {

    int size;
    int[] elements;
    int front, rear;

    // Create a circular queue
    public CircularQueue(int size) {
        this.size = size;
        elements = new int[size];
        //initially set both front and rear to -1
        front = -1;
        rear = -1;
    }

    private void enqueue(int item) {
        System.out.println("Trying to add item = " + item);
        if(isFull()) {
            System.out.println("Queue is already full");
            return;
        }
        //add to the queue, first time enqueue
        if(front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        }
        // circular queue
        else if(front !=0 && rear == size -1) {
            rear = 0;
        }
        else {
            rear++;
        }
        elements[rear] = item;
        System.out.println("Item " + item + " added to the queue.");
    }

    private void dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is already empty");
            return;
        }
        //remove from the queue
        int itemToDelete = elements[front];
        //only one element, last item to remove, and reset it.
        if(front == rear) {
            front = -1; // reset the queue
            rear = -1;
        }
        else if (front == size -1) {
            front = 0;
        }
       else {
           front = front + 1; //increase the front by one.
        }
        System.out.println("Item removed from the queue = " + itemToDelete);
    }

    private boolean isEmpty() {
        System.out.println("isEmpty() : Front = " + front + " and Rear = " + rear);
        return front == -1;
    }

    private boolean isFull() {
        System.out.println("isFull() : Front = " + front + " and Rear = " + rear);
        if(front == 0 && rear == size -1) return  true;
        return false;
    }

    private void size() {
        System.out.println("Total size of the queue is : " + size + " and Front = " + front + " and Rear = " + rear);
    }

     void displayElementsInQueue() {
        if(front == -1) {
            System.out.println("No Elements to display");
            return;
        }
         System.out.print("Elements are\n-----------  ");
        for(int i = front; i<= rear; i++) {
            System.out.print(elements[i] + " ");
        }
         System.out.println(" -----------");
    }
    static void displayElements(CircularQueue circularQueue) {
        // display the elements in queue
        IntStream stream = Arrays.stream(circularQueue.elements);
        System.out.println("\nPrinting elements here :\n--------------------------" );
        stream.forEach(value -> System.out.print(value + "  "));
        System.out.println("\n--------------------------");
    }
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.size();
        circularQueue.dequeue();
        circularQueue.enqueue(4);
        circularQueue.enqueue(3);
        circularQueue.enqueue(2);
        circularQueue.displayElementsInQueue();
        circularQueue.enqueue(100);
        circularQueue.enqueue(90);
        circularQueue.enqueue(0);
        circularQueue.enqueue(190);
        displayElements(circularQueue);
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.displayElementsInQueue();
    }
}
