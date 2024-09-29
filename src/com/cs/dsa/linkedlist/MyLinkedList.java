package com.cs.dsa.linkedlist;

/*
   In MyLinkedList elements are linked using pointers, Collection of Nodes.
   Node,it has data & next that points to the data of the next node.[ Node here itself can be a class with data & next field ]

   Node : data, next
   Node : head [ will point to the first Node ]
   Node : next [ will point to the next Node ],
   only the data value is int, others are Node

*/

public class MyLinkedList {
    Node head;
    //create class Node that will have data and next, head will point to the first Node

    class Node {
        int data;
        Node next;

        //create the node first time
        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        // Insert at the end
        private void insert(MyLinkedList linkedList, int data) {
            //create node out of that data
            Node newNode = new Node(data);

            /* see if the list is empty, it's going to be first node */
            if (linkedList.head == null) {
                head = newNode;
            }
            //else insert node after traversing till end of the node
            else {
                Node lastNode = linkedList.head;
                while (lastNode.next != null) {
                    lastNode = lastNode.next;
                }
                //insert
                lastNode.next = newNode;
            }
            //System.out.println("Linked list is created => " + linkedList.head.data);
        }

        // Insert at the beginning
        private void insertAtFront(MyLinkedList linkedList, int data) {
            Node newNode = new Node(data);
            if (head != null) {
                newNode.next = head;
            }
            head = newNode;
        }

        // provided the key, it deletes the node
        private void deleteNode(int key) {
            Node headNode = head; // get the current head
            Node prevNode = null; // initialize prev. node to null
            // if node to be deleted is head itself
            if(headNode.data == key) {
                head = headNode.next;
                return;
            }
           // if node to be deleted is other than head itself, just traverse
           while (headNode!= null && headNode.data !=key) {
               prevNode = headNode;
               headNode = prevNode.next;
           }
           // not found
           if(headNode == null) {
               return;
           }
           // found
           prevNode.next = headNode.next;
        }

        //print the data
        private void printData(MyLinkedList linkedList) {
            System.out.print("Printing data ..... => ");
            Node node = linkedList.head; //get the first Node with the help of the Head

            while (node != null) {
                System.out.print(node.data + "   ");
                node = node.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        MyLinkedList.Node node = linkedList.new Node(4);

        node.insert(linkedList, 5);
        node.insert(linkedList, 15);
        node.insert(linkedList, 25);
        node.insert(linkedList, 35);
        node.insert(linkedList, 45);
        node.insertAtFront(linkedList, 33);
        node.insertAtFront(linkedList, 200);
        node.deleteNode(33);
        node.insertAtFront(linkedList, 330);
        node.deleteNode(330);
        node.printData(linkedList);
    }
}

