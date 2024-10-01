package com.cs.dsa.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Created By Badri Paudel on 02/08/2022 - Software Developer at Threadcode Technologies
 * Binary Tree in DS, is a tree that has at most two children, Left (L) and Right (R).
 * Refer to : https://en.wikipedia.org/wiki/Binary_tree#:~:text=In%20computer%20science%2C%20a%20binary,child%20and%20the%20right%20child.&text=It%20is%20also%20possible%20to,is%20an%20ordered%2C%20rooted%20tree.
 * Why Trees?
 * One reason to use trees might be because you want to store information that naturally forms a hierarchy.
 * For example, the file system on a computer:
 */
public class BinaryTree {
    public Node rootNode;

    public BinaryTree() {
        rootNode = null;
    }

    // Creating a Node in Binary Node, as BT has many nodes, which ultimately have Left and Right
    class Node {
        int element; //data
        Node left, right; //Left and Right Nodes

        public Node(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }

    /*
     * Return the node if present else null
     * Travel from root node
     * if element to be searched is less than value at root node, go to left node else right node
     */
    protected Node searchNode(Node searchingNode, Node root) {
        if (rootNode == null || searchingNode == null) {
            return null;
        }
        Node rootNode = root;
        while (rootNode != null) {
            // searchingNode == rootNode; // Use this if you want to know they'are same node (as they will refer to the same memory address.
            if ((searchingNode.element) == rootNode.element) {
                return rootNode;
            } else if ((searchingNode.element) < rootNode.element) {
                rootNode = rootNode.left;
            } else {
                rootNode = rootNode.right;
            }
        }
        return null;
    }

    /*
     * Created by Badri Paudel on : 02/09/2022
     * Tree traversal is the process of visiting each node once only in any order [n!] .
     * BFS starts at lowest or(highest) node visiting each node level by level until all the
       nodes are visited and moving up (or down)
     * Docs : https://en.wikipedia.org/wiki/Breadth-first_search
    */

    protected void searchBFS() throws InterruptedException {
        Node rNode = rootNode; // access to the root node
        Queue queue =  new LinkedList(); // queue to store visited nodes
        if (rNode != null) {
            queue.add(rNode); // visited add to the queue
            // visit all by looping
            System.out.print("Visiting values ::: ");
            while (!queue.isEmpty()) {
                rNode = (Node) queue.poll(); // pop that element off
                System.out.print(" " + rNode.element);
                // VisIts left node and puts it into the queue
                if (rNode.left != null) {
                    queue.add(rNode.left);
                }
                // visits right node and put it in the queue
                if (rNode.right != null) {
                    queue.add(rNode.right);
                }
            }
            System.out.println(" = Travelling BFS finished");
        }
    }

        /*
          * Tree traversal is the process of visiting each node once only in any order [n!] .
          * DFS proceeds as far as possible to the left(or right) then backs up until the first one and repeat this until all the
            nodes are visited.
          * Docs : https://en.wikipedia.org/wiki/Depth-first_search
        */

      //  searchDFS()
        /*
           Searches recursively
         * Can search in three ways
         * 1. InOrder [LVR] (left, root, right)
         * 2. PreOrder[VLR] (Root, Left, Right)
         * 3. PostOrder [LRV] (Left, right, root)
         */
    // Order : InOrder [LVR] (left, root, right)
    protected void inOrder(Node root) {
        if(root == null) return;
        // recursive call
        inOrder(root.left);
        System.out.print(root.element + " -> ");
        inOrder(root.right);
    }

    // PreOrder[VLR] (Root, Left, Right)
    protected void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.element + " -> ");
        // recursive call
        preOrder(root.left);
        preOrder(root.right);
    }

    // PostOrder [LRV] (Left, Right, Root)
    protected void postOrder(Node root) {
        if(root == null) return;
        // recursive call
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.element + " -> ");
    }

    public static void main(String[] args) throws InterruptedException {
        BinaryTree binaryTree = new BinaryTree();

        BinaryTree.Node node = binaryTree.new Node(6);
        binaryTree.rootNode = node;
        Node node2 = binaryTree.new Node(3);
        BinaryTree.Node node_ = binaryTree.new Node(4);
        BinaryTree.Node node3 = binaryTree.new Node(26);
        Node node4 = binaryTree.new Node(20);
        Node node5 = binaryTree.new Node(30);

        node.left = node2;// smaller to left
        node.left.right = node_;
        node.right = node3; // larger to right
        node.right.left = node4;
        node.right.right = node5;

        Node foundNode = binaryTree.searchNode(node5, binaryTree.rootNode);
        System.out.println(foundNode != null ? "Node found with element = " + foundNode.element : "No Node found");
        System.out.println("---------------------------\n---------------------");
        binaryTree.searchBFS();

        System.out.print("In-Order DFS : ");
        binaryTree.inOrder(binaryTree.rootNode);
        System.out.println();
        System.out.print("Pre-Order DFS : ");
        binaryTree.preOrder(binaryTree.rootNode);
        System.out.println();
        System.out.print("Post-Order DFS : ");
        binaryTree.postOrder(binaryTree.rootNode);
    }

}
