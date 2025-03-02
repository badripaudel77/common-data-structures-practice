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
            System.out.println("Node with value: " + value + "inserted in the BST at root position.");
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
                    System.out.println("Node with value: " + value + " inserted in the BST (left side)");
                    return;
                }
                temp = temp.left;
            }
            else {
                if(temp.right == null) {
                    temp.right = newNode;  // insert node to the right
                    System.out.println("Node with value: " + value + " inserted in the BST (right side)");
                    return;
                }
                temp = temp.right;
            }
        }
    }

    public void printTree(Node root) {
        if(root != null) {
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }

    // Check if node with given value exists in BST (recursively)
    public boolean contains(Node rootNode, int value) {
        if(rootNode == null) {
            return false;
        }
        if(rootNode.data == value) {
            return true;
        }
        while(rootNode != null) {
            rootNode = value < rootNode.data ? rootNode.left : rootNode.right;
            return contains(rootNode, value);
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeV2 binaryTree = new BinaryTreeV2(50);

        binaryTree.insertNode(22);
        binaryTree.insertNode(25);
        binaryTree.insertNode(55);

        binaryTree.printTree(binaryTree.root);
        System.out.println();

        System.out.println(binaryTree.contains(binaryTree.root, 44));
        System.out.println(binaryTree.contains(binaryTree.root, 55));
        System.out.println(binaryTree.contains(binaryTree.root, 50));
        System.out.println(binaryTree.contains(binaryTree.root, 22));
        System.out.println(binaryTree.contains(binaryTree.root, 100));
    }
}
