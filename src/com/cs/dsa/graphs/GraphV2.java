package com.cs.dsa.graphs;

import java.util.*;

/**
 * Graph has vertex and edge (V, E). Vertices are connected with the help of edge
 * For example, for this graph:
 *     a
 *   /    \
 *  b ---- c
 *  Adjacency list would be as follows:
 *  "a" = [b, c]
 *  "b" = [a, c]
 *  "c" = [a, b]
 *
 *  Here, "a" is the key to the hashmap, [b,c] is the value (as arraylist) of that key. Meaning,
 *  a is connected to b and c.
 */
public class GraphV2 {
    Map<String, Set<String>> adjList = new HashMap<>();

    public GraphV2() {
    }

    // Adding is: O(1)
    public boolean addVertex(String vertex) {
        boolean isVertexPresent = adjList.containsKey(vertex);
        if(isVertexPresent) {
            return false;
        }
        adjList.put(vertex, new HashSet<>());
        System.out.println("Vertex: " + vertex + " added to the graph with empty adjacency list.");
        return true;
    }

    // Adding edge is also: O(1)
    public boolean addEdge(String fromVertex, String toVertex) {
        boolean isVerticesPresent = adjList.containsKey(fromVertex) && adjList.containsKey(toVertex);
        if(!isVerticesPresent) {
            return false;
        }
        adjList.get(fromVertex).add(toVertex);
        adjList.get(toVertex).add(fromVertex);
        System.out.println("Edge connected in between : " + fromVertex + " and " + toVertex + ".");
        return true;
    }

    // Removing vertex is, removing itself from map but also unlinking it from other adjacency list.
    // O(n) or, O(v), v is the no of connected vertices.
    public boolean removeVertex(String vertex) {
        boolean isVertexPresent = adjList.containsKey(vertex);
        if(!isVertexPresent) {
            return false;
        }
        // unlink from other vertices' adj list
        Set<String> connectedVertices = adjList.get(vertex);
        for(String v: connectedVertices) {
            adjList.get(v).remove(vertex);
        }
        adjList.remove(vertex);
        System.out.println("Vertex : " + vertex + " removed from the graph.\n");
        return true;
    }

    // Remove edge between given two vertices: O(n)
    public boolean removeEdge(String fromVertex, String toVertex) {
        boolean isVerticesPresent = adjList.containsKey(fromVertex) && adjList.containsKey(toVertex);
        if(!isVerticesPresent) {
            System.out.println("Invalid from and/or to vertex.\n");
            return false;
        }
        adjList.get(fromVertex).remove(toVertex);
        adjList.get(toVertex).remove(fromVertex);
        System.out.println("Edge in between " + fromVertex + " and " + toVertex + " removed.\n");
        return true;
    }

    // Print: Vertex and its associated vertices (with whom it is connected to)
    // O(n)
    public void printGraph() {
        Set<String> vertices = adjList.keySet();
        if(vertices == null) {
            System.out.println("No vertex was found in the graph.");
            return;
        }
        System.out.println("Printing >>>");
        for(String v: vertices) {
            Set<String> connectedVertices = adjList.get(v);
            System.out.println("Vertex : " + v + " is connected to : " + connectedVertices + ".");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphV2 graph = new GraphV2();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.printGraph();

        graph.addEdge("A", "B");
        graph.addEdge("B", "A"); // We have used set, so it will not add duplicates. Because A to B means, B to A
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");

        graph.printGraph();

        graph.removeVertex("A");

        graph.printGraph();

        graph.removeEdge("B", "C");
        graph.printGraph();
    }
}
