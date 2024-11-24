package com.cs.dsa.linkedlist;

import java.util.HashSet;
import java.util.Stack;

/**
 * LinkedList Version2 (V2)
 * Implement: append(value), print, remove last, prepend(value), remove first, get(index), set(index, value),
 * insert(index, value), remove(index), reverse
 */
public class LinkedList {
    Node head;
    Node tail;
    int length;

    public LinkedList() {

    }

    public LinkedList(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Print all the values of all the nodes in the LinkedList : O(n)
    public void printList() {
        if(length == 0) {
            System.out.println("Currently there are no nodes in the LL");
            return;
        }

        System.out.print("LinkedList has following Node/s (with value/s): ");
        Node temp = head;
        if(temp == null) return;
        while(temp != null) {
            System.out.print(temp.value + " => ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Add to the head of the LinkedList : O(1)
    public void prepend(int value) {
        Node newNode = new Node(value);
        // Empty LL : head == null || tail == null
        if(length == 0) {
            head = tail = newNode;
        }
        if(length > 0) {
            Node temp = head;
            head = newNode;
            head.next = temp;
        }
        length++;
        System.out.printf("Node with value \"%d\" created and prepended to the LL \n", value);
    }

    // get the node at given index : O(n)
    public Node getByIndex(int index) {
        if(length <= 0 || index >= length || index < 0) {
            System.out.println("Node at index " + index + " doesn't exist.");
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        System.out.println("Getting Node at index : " + index + " with value : " + temp.value + " => " + temp);
        return temp;
    }
    
    // get the node with given value : O(n)
    public Node getByValue(int value) {
        Node node = null;
        if(length <= 0) {
            System.out.println("List is empty");
            return null;
        }
        Node temp = head;
        for (int i = 0; i < length; i++) {
            if(temp.value == value) {
                node = temp;
                break;
            }
            temp = temp.next;
        }
        System.out.println("Getting Node with given value : " + value + " => " + node);
        return node;
    }

    // Removes first node : O(1)
    public Node removeFirst() {
        Node temp = head;
        if(length == 0) {
            System.out.println("There is no node to be removed.");
            return null;
        }
        // Means, there is a head so remove it.
        if(length == 1) {
            head = tail = null;
            length--;
            System.out.println("First node with value : " + temp.value + " removed => " + temp);
            return temp;
        }
        head = temp.next;
        temp.next = null;
        length--;
        System.out.println("First node with value : " + temp.value + " removed => " + temp);
        return temp;
    }

    // Remove last : O(n)
    public Node removeLast() {
        if(length == 0) return null;
        if(length == 1) {
             Node node = removeFirst();
             return node;
        }
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next; // points to second last, which will be the final tail.
        }
        temp.next = null;
        tail = temp;
        length--;
        System.out.println("Last node removed, now tail points to " + tail + " which has value of : " + tail.value);
        return temp; // Just returning the current tail.
    }

    // Remove the node at given index : O(n)
    public Node removeNodeAtIndex(int index) {
        if(length == 0 || index < 0 || index >= length) {
            System.out.println("Invalid removed for index " + index + " when length is just : " + length);
            return null;
        }
        if(index == 0) {
            return removeFirst();
        }
        if(index == length-1) {
            return removeLast();
        }
        Node prev = getByIndex(index-1);
        Node nodeToBeRemoved = prev.next;
        prev.next = nodeToBeRemoved.next;
        nodeToBeRemoved.next = null;
        length--;
        System.out.println("Node at index : " + index + " removed which had value of : " + nodeToBeRemoved.value);
        return nodeToBeRemoved;
    }

    // Reverse the LL: O(n), in-place
    /**
     * Swap head and tail and change the direction of the pointer (pointing to the next)
     * Visualize by drawing a diagram, it should be clear.
     * Main idea is to maintain pointer to prev, after and navigate accordingly until
     * all the pointers(next) are flipped back.
     */
    public void reverse() {
        if(length == 0) {
            System.out.println("LL is empty, so can't be reversed.");
            return;
        }
        if(length == 1) {
            System.out.println("There is only one node in the LL, already reversed.");
            return;
        }
        // swap the head and tail
        Node temp = head;
        head = tail;
        tail = temp;

        Node prev = null;
        Node after;

        // change the direction of the pointer
        for(int i=0; i< length; i++) {
            after = temp.next;
            temp.next = prev;
            prev = temp;
            temp = after;
        }
        System.out.println("LL is now reversed.");
    }

    // Reverse LL V2 using extra space, TC: O(n), SC: O(n)
    // Stack is the best ds for storing as it has LIFO pattern which suits the need for this particular case.
    public void reverseLL() {
        if(length == 0) {
            System.out.println("LL is empty, so can't be reversed.");
            return;
        }
        if(length == 1) {
            System.out.println("There is only one node in the LL, already reversed.");
            return;
        }
        Node temp = head;
        Stack<Node> nodes = new Stack<>();
        while(temp != null) {
            nodes.add(temp);
            temp = temp.next;
        }
        System.out.print("LL is now reversed, printing it : ");
        nodes.forEach(node -> System.out.print(node.value + " => "));
        System.out.println();
    }

    public Node getHead() {
        System.out.println("Currently head is pointing at node : " + head + " with value: " + head.value);
        return this.head;
    }

    public Node getTail() {
        System.out.println("Currently tail is pointing at node : " + tail + " with value: " + tail.value);
        return this.tail;
    }

    /**
     * Finds the middle node (one pointer moves one time and another two times, once we reach the end of the list, slow pointer is the middle element.
     * Another approach is to count the no of nodes, and then get the node at length/2 index.
     */
    public Node findMiddleNode() {
        Node oneTimePointer = head;
        Node twoTimesPointer = head;

        while(twoTimesPointer != null && twoTimesPointer.next != null) {
            oneTimePointer = oneTimePointer.next;
            twoTimesPointer = twoTimesPointer.next.next;
        }
        return oneTimePointer;
    }

    /**
     * Detect if there is a loop (has a cycle or not) in the LL
     * Same approach with slow & fast pointer, if they meet at same index(place), there is a loop, if fast reaches the end of the list, there is no loop
     */
    public void hasLoop() {
       Node slow, fast;
       slow = fast = head;
       boolean hasCycle = false;

        while(fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
           if(slow == fast) {
               hasCycle = true;
               break;
           }
       }
        System.out.println("Does LL contain the cycle ? => " + hasCycle);
    }

    /**
     * @return kth Node
     * Implement a method called findKthFromEnd that returns the k-th node from the end of the list.
     * If the list has fewer than k nodes, the method should return null.
     */
    public Node findKthElement(int k) {
        if(k < 0 || head == null) {
            return null;
        }
        if(head.next == null && k == 0) {
            return  head;
        }
        // First find the no of nodes in a LL
        int count = 1;
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
            count++;
        }
        Node secondTemp = head;
        if(count - k < 0) {
            return null;
        }
        // get the kth node from the end with the help of count
        for(int i =0; i< count-k; i++) {
            secondTemp = secondTemp.next;
        }
        return secondTemp;
    }

    /**
     * Using slow and fast pointers
     * Without using count / length attribute
     */
    public Node findKthElementV2(int k) {
        Node fast = head;
        Node slow = head;

        for(int i = 0; i< k; i++) {
            if(fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * EG: Input: LinkedList: 1 -> 2 -> 3 -> 1 -> 4 -> 2 -> 5
     * Output: LinkedList: 1 -> 2 -> 3 -> 4 -> 5
     * Modify in-place
     * Time : O(n), Space: O(n)
     */
    public void removeDuplicates() {
        Node current = head;
        Node prev = null;
        if(current == null || current.next == null) {
            // either head is null or LL has only one element / no duplicate
            return;
        }
        HashSet<Integer> visitedNodes = new HashSet<>();
        while(current != null) {
            if(visitedNodes.contains(current.value)) {
                // This is the duplicate so change the pointer
                prev.next = current.next;
            }
            else {
                visitedNodes.add(current.value);
                prev = current;
            }
            current = current.next;
        }
        System.out.println("Duplicates removed if there were any.");
    }

    // Time: O(n), Space: O(1)
    public Node removeDuplicatesV2() {
        Node result = head;
        while(head != null && head.next != null) {
            if(head.value == head.next.value) {
                head.next = head.next.next;
            }
            else {
                head = head.next;
            }
        }
        return result;
     }

    /**
     * Sorted list:
     * 1 - 1 -2 -3-3-5 -> null
     * Output: 2 -> 5 -> null
     */
    public Node removeDuplicatesKeepDistinct() {
        Node current = head;
        Node prev = null;
        Node resultHead = null;

        if(current == null || current.next == null) {
            return current;
        }

        while(current != null) {
            if(current.next != null && current.value == current.next.value) {
                int currentVal = current.value;
                while (current != null && current.value == currentVal) {
                    // skip the duplicate
                    current = current.next;
                }
                if(prev != null) {
                    prev.next = current;
                }
            }
            else {
                if(resultHead == null) {
                    resultHead = current;
                }
                prev = current;
                current = current.next;
            }
        }
        return resultHead;
     }

    public void createLoop() {
        tail.next = head;
    }

}

class Runner {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(10);
        linkedList.printList();

        linkedList.prepend(12);
        linkedList.prepend(14);
        linkedList.printList();

        LinkedList.Node nodeByIndex = linkedList.getByIndex(2);
        System.out.println("Node by index : " + nodeByIndex);
        LinkedList.Node nodeByValue = linkedList.getByValue(13);
        System.out.println("Node by value : " + nodeByValue);

        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.printList();

        linkedList.removeLast();

        linkedList.prepend(1);
        linkedList.prepend(3);
        linkedList.prepend(5);
        linkedList.prepend(25);
        linkedList.prepend(35);
        linkedList.printList();

        linkedList.removeLast();
        linkedList.printList();

        linkedList.removeNodeAtIndex(1);
        linkedList.printList();

        linkedList.getHead();
        linkedList.getTail();
        linkedList.printList();

        linkedList.reverse();
        linkedList.printList();

        linkedList.reverseLL();

        linkedList.printList();
        linkedList.prepend(100);
        linkedList.prepend(100);
        linkedList.findMiddleNode();

         linkedList.findKthElement(2);
        linkedList.findKthElement(5);
        linkedList.findKthElement(3);
        linkedList.findKthElement(4);
        linkedList.findKthElement(1);
        linkedList.findKthElementV2(2);
         linkedList.removeDuplicates();
        linkedList.removeDuplicatesKeepDistinct();
        linkedList.removeDuplicatesV2();

        // Create the cycle (loop): tail.next = head;
        linkedList.createLoop();
        linkedList.hasLoop();

        // linkedList.printList(); // Gives infinite loop as it contains a cycle (modified above)
    }
}
