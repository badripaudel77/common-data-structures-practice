package com.cs.dsa.stack_queue;

 /*
    Queue is also similar to stack but it follows FIFO approach.
    First added is first to be deleted.
    Open at both ends.

    Possible operations :
    ==> add [ enqueue ], remove [ dequeue ], isFull(), isEmpty(), size(), .........

    Time complexity :
                    BigO : O(1) for all the operations.

 */

public class Queue {

    int size;
    int elements[];
    int rear, front;

    public Queue(int size) {
        this.size = size;
        elements  = new int[size];

        //initially front = -1
        front = -1;
    }

    private void enqueue(int item) {
           if(isFull()) {
               System.out.println("Queue is already full. ");
               return;
           }
           front = front+1;
           elements[front] = item;
           System.out.println("Item "+ item + " added to the queue.");
    }

    private void dequeue() {
       if(isEmpty()) {
           System.out.println("Queue is already empty.");
           return;
       }
        System.out.println("Item " + elements[front] + " removed successfully.");
        front--;
    }

    private boolean isEmpty() {
        return front == -1;
    }

    private boolean isFull() {
        return front == size -1;
    }

    private void size() {
        System.out.println("Total Size of the queue is " + size);
    }

    private void currentSize() {
        System.out.println("current size of the queue is " + (size - (front + 1)));
    }

    public static void main(String[] args) {

        Queue queue = new Queue(3);
        queue.size();
        queue.currentSize();
        queue.dequeue();
        queue.enqueue(4);
        queue.currentSize();
        queue.enqueue(4);
        queue.enqueue(4);
        queue.enqueue(4);
        queue.currentSize();

    }
}
