package com.cs.dsa.binarytrees;

import java.util.ArrayList;
import java.util.List;

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

    // Traverse the tree using BFS method.
    /**
     * Visit nodes level by level
     */
    public List<Integer> bfsTraversal() {
        List<Integer> result = new ArrayList<>();
        List<Node> queue = new ArrayList<>();
        Node current = root;
        if(root == null) {
            return result;
        }
        queue.add(current);
        while(queue.size() > 0) {
            current = queue.remove(0);
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null) {
                queue.add(current.right);
            }
            result.add(current.data); // visited
        }
        return result;
    }

    // DFS
    //1. Pre-Order (VLR -> Root -> Left(Recursively) -> Right(Recursively)
    public List<Integer> preOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        Node current = root;
        preOrder(current, result);
        return result;
    }

    // 2. Post-Order (LRV -> Left(Recursively) -> Right(Recursively) -> Root
    public List<Integer> postOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        Node current = root;
        postOrder(current, result);
        return result;
    }

    // 3. In-Order (LVR -> Left(Rec) -> Root -> Right(Rec))
    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        Node current = root;
        inOrder(current, result);
        return result;
    }

    public Integer findKthSmallestElement(int k) {
        List<Integer> dfsResult = inOrderTraversal();
        if(k <= dfsResult.size()) {
            return dfsResult.get(k-1);
        }
        return null;
    }

    private void preOrder(Node current, List<Integer> result) {
        if(current != null) {
            result.add(current.data);
            preOrder(current.left, result);
            preOrder(current.right, result);
        }
    }

    private void postOrder(Node current, List<Integer> result) {
        if(current != null) {
            postOrder(current.left, result);
            postOrder(current.right, result);
            result.add(current.data);
        }
    }

    private void inOrder(Node current, List<Integer> result) {
        if(current != null) {
            inOrder(current.left, result);
            result.add(current.data);
            inOrder(current.right, result);
        }
    }


    public static void main(String[] args) {
        BinaryTreeV2 binaryTree = new BinaryTreeV2(50);

        binaryTree.insertNode(22);
        binaryTree.insertNode(25);
        binaryTree.insertNode(55);
        binaryTree.insertNode(21);

        binaryTree.printTree(binaryTree.root);
        System.out.println();

        System.out.println(binaryTree.contains(binaryTree.root, 44));
        System.out.println(binaryTree.contains(binaryTree.root, 55));
        System.out.println(binaryTree.contains(binaryTree.root, 50));
        System.out.println(binaryTree.contains(binaryTree.root, 22));
        System.out.println(binaryTree.contains(binaryTree.root, 100));

        List<Integer> result = binaryTree.bfsTraversal();
        System.out.println("Result of BFS traversal : " + result);

        System.out.println("Result of DFS - Pre-Order traversal : " + binaryTree.preOrderTraversal());
        System.out.println("Result of DFS - Post-Order traversal : " + binaryTree.postOrderTraversal());
        System.out.println("Result of DFS - In-Order traversal : " + binaryTree.inOrderTraversal());

        System.out.println("2nd smallest element is : " + binaryTree.findKthSmallestElement(2));
        System.out.println("4th smallest element is : " + binaryTree.findKthSmallestElement(4));
        System.out.println("10th smallest element is : " + binaryTree.findKthSmallestElement(10));
    }
}
