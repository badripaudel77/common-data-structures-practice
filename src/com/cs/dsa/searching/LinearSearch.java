package com.cs.dsa.searching;

/*
   We do linear search of any items.
   Linear simply mean from left to right [ r ti l ]  as in daily life.
   Array Search , if not found returns -1.

  - has time complexity of n i.e Big Oh of n O(n) as time is linearly dependent on input size of an array
 */

import java.util.Arrays;

public class LinearSearch {

    public static void main(String[] args) {

        int itmes[] = {12, 34, 5, 6, 67};
        int itemToSearch = 6;

        int itemToUpdate = 34;
        int updateValue = 23;

        int itemToDelete = 23;

        //call the method [for searching]
        System.out.println("original array is " + Arrays.toString(itmes));
        LinearSearch.searchElement(itmes, itemToSearch);
        System.out.println("\n");

        //update the element
        System.out.println("original array is " + Arrays.toString(itmes));
        LinearSearch.updateElement(itmes, itemToUpdate, updateValue);
        System.out.println("\n");

        //delete an element
        System.out.println("original array is " + Arrays.toString(itmes));
        LinearSearch.deleteElement(itmes, itemToDelete);
        System.out.println("\n");

    }

    //method for linear search
    public static void searchElement(int[] items, int itemToFind) {
        //length of an array items
        int lenOfItems = items.length;
        int i;
        int iteratinsToFindElem = 0;
        boolean flag = false;

        if (lenOfItems <= 0) {
            System.out.println("please pass some items.");
            return;
        }

        //traverse each array items , for n inputs it has to iterate n times, so complexity is O(n)
        for (i = 0; i < lenOfItems; i++) {
            iteratinsToFindElem++;

            if (items[i] == itemToFind) {
                flag = true;
                break;
            }
        }
        if (flag)
            System.out.println("Yes the element " + itemToFind + " is present in the given items array. And it is found after "+ iteratinsToFindElem + " iterations.");
        else
            System.out.println("Sorry the element " + itemToFind + " is not present in the given items array.");
    }

    //update element
    public static void updateElement(int[] items, int elemToUpdate, int updateValue) {
        //length of an array items
        int lenOfItems = items.length;
        int i;
        Integer index = null;

        if (lenOfItems <= 0) {
            System.out.println("Please pass some elements.");
            return;
        }

        //traverse each array items , for n inputs it has to iterate n times, so complexity is O(n)
        for (i = 0; i < lenOfItems; i++) {
            if (items[i] == elemToUpdate) {
                //if item is found, then set index to i
                index = i;
                break;
            }
        }

        //only update if index is non-null
        if (index == null) {
            System.out.println("sorry the element "+ elemToUpdate + " is not present in items array.");
            return;
        }
        else items[index] = updateValue;

        System.out.print("After updating an element " + elemToUpdate + " at index " + index + "array is : ");
        for (i = 0; i < lenOfItems; i++) {
            System.out.print(" " + items[i]);
        }
    }

    //delete the item from items
    public static void deleteElement(int items[], int itemToDelete){
        int lenOfItems = items.length;
        int i;

        Integer index = null;
        if (lenOfItems <= 0) {
            System.out.println("Please pass some elements. ");
            return;
        }

        //traverse each array items ,for n inputs it has to iterate n times, so complexity is O(n)
        for (i = 0; i < lenOfItems; i++) {
            if (items[i] == itemToDelete) {
                //if item is found, then set i to index
                index = i;
                break;
            }
        }
            if (index == null) {
                System.out.println("sorry the element " + itemToDelete + " is not present.");
                return;
            }

            for (i = index; i < lenOfItems-1; ++i) {
                System.out.print("index " + i);
                items[i] = items[i + 1];
            }

            System.out.print("After deleting an item " + itemToDelete +" at index " + index + " the array is : ");
            for (i = 0; i < lenOfItems-1; i++) {
                System.out.print(" " + items[i]);
            }
        }
    }

