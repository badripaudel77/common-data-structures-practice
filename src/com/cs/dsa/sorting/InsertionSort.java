package com.cs.dsa.sorting;

import java.util.Arrays;

 /*
      Insertion sort divides the whole array into the two sub arrays and maintains one as sorted and one as unsorted.
      for eg : left sub-array is the sorted and right as unsorted.

    -- The element to be inserted at the left (sorted part ) has to find the appropriate position to insert.
    -- compare it with other elements in the "sorted " sub-array and swap if are unsorted .
    -- Insert the value and repeat this process.

    1) store the second element at the some one variable (say value) [ because we divide the first one element and rest into two sub-array , first time the left one is sorted as it contains only one element.
    2) If  value < previous element swap them


    complexity analysis :
                         Best case  : O(n) as we don't have to enter the inner loop in best case.
                         worst case : o(n^2) as we have to enter the both loops O(n) * O(n)
  */

public class InsertionSort {

    public static void main(String[] args) {
        int elements[] = { -1,9,7,0 };

        System.out.println("original array is : " + Arrays.toString(elements));

        insertionSort(elements);

        System.out.println("After Sorting Array is : " + Arrays.toString(elements));

    }

    public static void insertionSort(int [] elements) {

        int len = elements.length;

        int i, value, position, temp;


        // O(n)
        for (i = 1; i < len; i++) {
            value = elements[i];
            position = i;

            // while the element to insert is less than the previous element.
            //O(n)
            while( position > 0 &&  elements[position - 1] > value) {

                //swap them
                temp = elements[position];
                elements[position] = elements[position-1];
                elements[position -1] = temp;

                //decrease the position to till 1st index if required.
                position --;
            }

        }

    }
}

