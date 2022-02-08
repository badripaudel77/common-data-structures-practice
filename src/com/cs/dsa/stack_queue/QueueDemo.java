package com.cs.dsa.stack_queue;

public class QueueDemo {

    private final int elements[];
    private final int size;
    private int front, rear;

    public QueueDemo(int size) {
        this.elements = new int[size]; //elements[] = {0/NULL,0/NULL,0/NULL} if size is 3
        this.size = size;
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int item) {
        if(!isFull()) {
            //TODO : insert item
            //first insertion if will go to -1 + 1 = 0th position

            if (front == -1) front = 0;
             rear = rear + 1;

            elements[rear] = item;
            System.out.println("Item " + item +" inserted.");
        }
        else {
            //queue is already packed
            System.out.println("Queue is already full");
        }
    }

    public void dequeue() {
        if(!isEmpty()) {
            //TODO : remove item
            //if(front >=rear) {
            //last removal
            int el = elements[front];
            if(front == 0) {
                front = -1;
                rear = -1;
            }
            else {
                front = front + 1;
            }
            System.out.println("Item " + el + " deleted.");
        }
        else {
            //queue is already empty
            System.out.println("Queue is already empty");
        }
    }

    public boolean isFull() {
       return (front == 0 && rear == size -1);
    }

    public boolean isEmpty() {
        return (front == -1 && rear ==-1);
    }

    public int giveSize() {
        return size;
    }

    public static void main(String[] args) {
        QueueDemo queueDemo = new QueueDemo(5);
        queueDemo.dequeue();

        queueDemo.enqueue(6);
        queueDemo.enqueue(7);
        queueDemo.enqueue(8);

        System.out.println(queueDemo.giveSize());

        queueDemo.dequeue();
    }
}
