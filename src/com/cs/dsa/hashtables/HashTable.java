package com.cs.dsa.hashtables;

import java.util.*;

public class HashTable {
    List<Node> values;
    int hashTableSize = 7;

    public HashTable() {
        values = new ArrayList<>(hashTableSize);
        for (int i = 0; i < hashTableSize; i++) {
            values.add(i, null);
        }
    }

    // Node will have key and value
    class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // O(1), general case. However, if we need to traverse if collision occur, it will be O(n)
    public void set(String key, int value) {
        Node newNode = new Node(key, value);
        int index = getHash(key, hashTableSize);
        Node existingNode = values.get(index);
        if(existingNode == null) {
            values.add(index, newNode);
            return;
        }
        // There is already a node, just add to the end
        while(existingNode.next != null) {
            existingNode = existingNode.next;
        }
        existingNode.next = newNode;
    }

    // O(1), general case. However, if we need to traverse if collision occur, it will be O(n)
    public int get(String key) {
        int index = getHash(key, hashTableSize);
        Node node = values.get(index);
        while(node != null) {
             if(node.key == key) {
                 return node.value;
             }
            node = node.next;
        }
        return 0; // not found
    }
    // return the index where value should be
    private int getHash(String key, int tableSize) {
        // generate the hash
        char[] chars = key.toCharArray();
        int hashValue = 0;
        int prime = 31; // small prime number
        for (int i = 0; i < chars.length; i++) {
            int ascii = (int) chars[i];
            hashValue = (hashValue * prime + ascii ) % tableSize;
        }
        return hashValue;
    }

    public void printTable() {
        Iterator<Node> nodeIterator = values.iterator();
        while (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();
            if(node != null) {
                System.out.println(" { " + node.key + " = " + node.value + " }");
            }
        }
    }

    public Character firstNonRepeatingChar(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c: arr) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        for (char a: arr) {
            if(map.get(a) == 1) {
                return a;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.printTable();

        hashTable.set("Mango", 100);
        hashTable.set("Orange", 50);
        hashTable.set("Apple", 200);
        hashTable.printTable();
        int apple = hashTable.get("Apple");
        System.out.println("Apple has value : " + apple);
        System.out.println("Guava has value : " + hashTable.get("Guava"));

        System.out.println("First non repeating character in leetcode : " + hashTable.firstNonRepeatingChar("leetcode"));
        System.out.println("First non repeating character in hheello : " + hashTable.firstNonRepeatingChar("hheeello"));
        System.out.println("First non repeating character in rraa : " + hashTable.firstNonRepeatingChar("rraa"));
    }
}