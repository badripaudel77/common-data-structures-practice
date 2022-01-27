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

public class CircularQueue {

    int size;
    int[] elements;
    int front, rear;

    public CircularQueue(int size) {
        this.size = size;
        elements = new int[size];

        //initially set both front and rear to -1
        front = rear = -1;
    }

    private void enqueue(int item) {
        if(isFull()) {
            System.out.println("Queue is already full");
            return;
        }
        //add to the queue, first time enqueue
        if(front == -1) front = front + 1;

        rear = (rear + 1) % size;  // position to insert
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

       else {
           front = (front + 1) % size; //increase the front by one.
        }
        System.out.println("Item removed from the queue" + itemToDelete);
    }

    private boolean isEmpty() {

        return front == -1;
    }

    private boolean isFull() {

        if(front == 0 && rear == size -1) return  true;
        return front == rear + 1;
    }

    private void size() {
        System.out.println("Total size of the queue is : " + size);
    }

    public static void main(String[] args) {

        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.size();
        circularQueue.dequeue();
        circularQueue.enqueue(4);
        circularQueue.enqueue(3);
        circularQueue.enqueue(2);

        circularQueue.enqueue(100);
        circularQueue.enqueue(90);
        circularQueue.enqueue(0);
        circularQueue.dequeue();
        circularQueue.dequeue();
    }
}
