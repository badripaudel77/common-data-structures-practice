package com.cs.dsa.graphs;

import java.util.LinkedList;

/*
 * Create by Badri Paudel on 02/12/2022
 * ref : https://www.tutorialspoint.com/data_structures_algorithms/graph_data_structure.htm
 * Graph (G) = (Vertex[V], Edege[E])
 *
 * Graph  has : adjacency list [adjacent vertices],
 */
public class Graph {
    private LinkedList<Integer> adjList[];

    // create a graph with no of vertices v
    public Graph(int v) {
        adjList = new LinkedList[v];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

   // add edge to graph, first create pic and simulate on paper, u = source node, v = destination
   protected void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u); // (u,v) = (v,u) for undirected graph
   }

    public static void main(String[] args) {
        Graph graph = new Graph(3); // with three vertices
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        System.out.println("len of adjacent list = " + graph.adjList.length);
        System.out.println("graph representation = " + graph.adjList[0] + ", " + graph.adjList[1] + "," + graph.adjList[2]);
    }
}
