package com.cs.dsa.vector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        // create a vector, vectors are synchronized
        Vector<String> shoppingItems = new Vector<>();

        shoppingItems.add("Headphones");
        shoppingItems.add("Monitors");
        shoppingItems.add("Keyboard");

        shoppingItems.addElement("USB");
        shoppingItems.add(1, "Bottle");
        System.out.println("Vectors : " + shoppingItems);

        List<String> myList = new ArrayList<>();
        myList.add("item1");
        myList.add("item2");
        myList.add("item3");

        // Concurrent modification during iteration
        for (String item : myList) {
            if (item.equals("item2")) {
                // Modifying the list while iterating
                myList.remove(item);  // This will throw ConcurrentModificationException
            }
        }
        System.out.println(" my list " + myList);

        Iterator<String> iterator = myList.iterator();
        while(iterator.hasNext()) {
            System.out.println("iterator = " + iterator.next());
        }
    }
}
