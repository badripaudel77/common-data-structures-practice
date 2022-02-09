package com.cs.dsa.stack_queue;

 /*
    Queue [ linear queue ] is also similar to stack, but it follows FIFO approach.
    First added is first to be deleted.
    Open at both ends, insertion and deletion are from only one respective end.

    Possible operations :
    ==> add [ enqueue ], remove [ dequeue ], isFull(), isEmpty(), size(), .........

    Time complexity :
                    BigO : O(1) for all the operations.

    usage : 1) Printer scheduling
            2) Call center

 */

public class Queue {
    int size;
    int[] elements;
    int front, rear;

    //create the queue of given size
    public Queue(int size) {
        this.size = size;
        this.elements  = new int[size];
        // Initially front and rear set to -1 [empty queue]
        this.front = -1;
        this.rear = -1;
    }

    public Queue() {

    }

    private void enqueue(int item) {
           if(isFull()) {
               System.out.println("Queue is already full. ");
               return;
           }
           if(front == -1 && rear == -1) {
               // for the first insertion
               this.front = 0;
               this.rear = 0;
           }
           // all other normal insertions
           elements[rear] = item;
           rear = rear + 1;
           System.out.println("Item "+ item + " added to the queue.");
    }

    private void dequeue() {
       if(isEmpty()) {
           System.out.println("Queue is already empty.");
           return;
       }
       if(front >= rear) {
           front = -1;
           rear = -1;
       }
        else front ++;
        System.out.println("front is :: " + front);
    }

    private boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    private boolean isFull() {
        return front == 0 && rear == this.size;
    }

    private void size() {
        System.out.println("Total Size of the queue is " + this.size);
    }


    public static void main(String[] args) {

        Queue queue = new Queue(3);
        queue.size();
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(4);
        queue.enqueue(4);
        queue.enqueue(4);
        queue.size();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
