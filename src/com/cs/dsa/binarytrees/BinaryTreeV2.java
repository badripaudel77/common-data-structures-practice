package com.cs.dsa.binarytrees;

// BST
public class BinaryTreeV2 {
    Node root;

    public BinaryTreeV2(int value) {
        Node node = new Node(value);
        root = node;
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // insert the node to the BST (either in left or right of the root node)
    public void insertNode(int value) {
        Node newNode = new Node(value);
        if(root == null) {
            root = newNode;
            return;
        }
        Node temp = root;
        while(temp != null) {
            if(temp.data == value) {
                return; // duplicate value found
            }
            if(value < temp.data) {
                if(temp.left == null) {
                    temp.left = newNode; // insert node to left
                    return;
                }
                temp = temp.left;
            }
            else {
                if(temp.right == null) {
                    temp.right = newNode;  // insert node to the right
                    return;
                }
                temp = temp.right;
            }
        }
        System.out.println("Node with value: " + value + "inserted in the BST");
    }

    public static void main(String[] args) {
        BinaryTreeV2 binaryTree = new BinaryTreeV2(50);
        binaryTree.insertNode(22);
        binaryTree.insertNode(25);
        binaryTree.insertNode(55);
    }
}
