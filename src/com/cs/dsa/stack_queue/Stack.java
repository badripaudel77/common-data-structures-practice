package com.cs.dsa.stack_queue;

/*
   Stack is an "abstract data type" that means defined by user's point of view in terms of possible values and operation
   on these data types.

   Possible operations in stack [ follows LIFO ]:
    ==> push(item), pop(), isFull(), isEmpty(), size(), ....

    Open at only one end.

    all of the operations are bigO(1).
 */


public class Stack {

    private  int elements[];
    private int capacity;
    int top;

    public Stack(int size) {
         elements = new int[size]; //create stack out of that given size
         capacity = size;
         top = -1; // initially stack is empty
    }

    private void push(int item) {
       //only can push if stack is not full already
        if(!isFull()) {
            top ++; // increase the value of top to next , if it was -1 at the beginning, at the first step it will be 0, first index
            elements[top] = item;
            System.out.println("Item "+ item + " inserted successfully");
        }
        else System.out.println("Stack is already full.");
    }

    //remove the item
    private void pop() {
          //only can remove if not empty already.
        if(!isEmpty()) {
            //point top to the one index below
            System.out.println("Item " + elements[top] + " deleted successfully.");
            top --;
        }
        else  System.out.println("Stack is empty already.");
    }

    // means if top = size -1 [ as index starts from 0]
    private boolean isFull() {
        return  top == capacity -1;
    }

    //means top == -1
    private boolean isEmpty() {
        return  top == -1;
    }

    //return the total size of the stack
    private void size() {
        System.out.println("size of the stack is : " + capacity);
    }

    //return the total size of the stack
    private void currentSize() {
        System.out.println("Current size of the stack is : " + (capacity - (top + 1)));
    }


    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.pop();
        stack.push(1);
        stack.pop();
        stack.currentSize();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.size();

    }
}
