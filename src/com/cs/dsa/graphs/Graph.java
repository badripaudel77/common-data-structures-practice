package com.cs.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Created by Badri Paudel on 02/12/2022
 * ref : https://www.tutorialspoint.com/data_structures_algorithms/graph_data_structure.htm
 * Graph (G) = (Vertex[V], Edege[E])
 * Graph  has : adjacency list [adjacent vertices],
 */
public class Graph {
    private LinkedList<Integer> adjList[];
    private Queue<Integer> queue;

    // create a graph with no of vertices v
    public Graph(int v) {
        adjList = new LinkedList[v];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList();
        }
        queue = new LinkedList<>();
    }

   // add edge to graph, first create pic and simulate on paper, u = source node, v = destination
   protected void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u); // (u,v) = (v,u) for undirected graph
   }

   // BFS
   /*
    * Start from the root node and explore all the neighbouring nodes
    * then select the nearest nodes and explore all the other unvisited nodes
    * visited [] and not-visited []
    *
    * Make a queue to keep track of the nodes to be visited, then explore all of it's neighbors if they've not been visited already
    *
    */
    protected void breadthFirstSearch(int root, int vertex) {
         boolean nodes[] = new boolean[vertex]; // to mark true if visited for all nodes in graph
         nodes[root] = true; // mark as visited that is passed
         queue.add(root); // add

        while (queue.size() != 0) {

            root = queue.poll(); // remove the element from queue's top
            System.out.print(root + " -> "); // print that recently visited node

            // explore all the adjacent nodes of the root[that vertex] and add them to queue just like before
            for (int i = 0; i< adjList[root].size(); i++) {
                int tempNode = adjList[root].get(i);// getting adjacent vertex
                // if it hasn't been visited already
                if(!nodes[tempNode]) {
                    nodes[tempNode] = true;
                    queue.add(tempNode);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(3); // with three vertices
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        System.out.println("len of adjacent list = " + graph.adjList.length);
        System.out.println("graph representation = " + graph.adjList[0] + ", " + graph.adjList[1] + "," + graph.adjList[2]);

        System.out.print("Breadth First ::: ");
        graph.breadthFirstSearch(1, 3);
    }
}
