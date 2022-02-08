package com.cs.dsa.binarytrees;
/*
 * Created By Badri Paudel on 02/08/2022 - Software Developer at Threadcode Technlogies
 * Binary Tree in DS, is a tree that has at most two children, Left (L) and Right (R).
 * Refer to : https://en.wikipedia.org/wiki/Binary_tree#:~:text=In%20computer%20science%2C%20a%20binary,child%20and%20the%20right%20child.&text=It%20is%20also%20possible%20to,is%20an%20ordered%2C%20rooted%20tree.
 * Why Trees?
 * One reason to use trees might be because you want to store information that naturally forms a hierarchy.
 * For example, the file system on a computer:
 */
public class BinaryTree {
    Node rootNode;

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
        if(rootNode == null || searchingNode == null) {
            return null;
        }
        Node rootNode = root;
        while (rootNode !=null) {
            if((searchingNode.element) == rootNode.element) {
                return rootNode;
            }
            else if((searchingNode.element)< rootNode.element) {
                rootNode = rootNode.left;
            }
            else {
                rootNode = rootNode.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        BinaryTree.Node node = binaryTree.new Node(6);
        binaryTree.rootNode = node;
        BinaryTree.Node node2 = binaryTree.new Node(3);
        BinaryTree.Node node3 = binaryTree.new Node(26);

        node.left = node2; // smaller to left
        node.right = node3; // larger to right

        Node foundNode = binaryTree.searchNode(null, binaryTree.rootNode);
        System.out.println(foundNode !=null ? "Node found with element = "+ foundNode.element : "No Node found");
    }

}
