package com.cs.dsa.linkedlist;

/*
   In LinkedList elements are linked using pointers, Collection of Nodes.
   Node,it has data & next that points to the data of the next node.[ Node here itself can be a class with data & next field ]

   Node : data, next
   Node : head [ will point to the first Node ]
   Node : next [ will point to the next Node ],
   only the data value is int, others are Node

*/

public class LinkedList {
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

        private void insert(LinkedList linkedList, int data) {
            //create node out of that data
            Node newNode = new Node(data);

            /* see if the list is empty */
            if(linkedList.head == null) {
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

        //print the data
        private void printData(LinkedList linkedList) {
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
        var linkedList = new LinkedList();
        LinkedList.Node node = linkedList.new Node(4);

        node.insert(linkedList,5);
        node.insert(linkedList,15);
        node.insert(linkedList,25);
        node.insert(linkedList,35);
        node.insert(linkedList,45);

        node.printData(linkedList);
    }
}

