package com.cs.dsa.sorting;

/*
   In bubble sort we make comparisons between two adjacent elements and swap them if required.

   for first pass it requires n-1 passes, for second n-2 passes and so on.

   (n-1) + (n-2) + ..... + 3 + 2 +1  = n(n-1) /2 = n^2/2 + n/2 = O(n^2)
 */

public class BubbleSort {
    public static void main(String[] args) {

        int elements[] = { 45, 36,12 ,-1, 0};
        BubbleSort.sortElements(elements);
    }

    //sorting elem
    public static void sortElements(int [] elements) {
        int len = elements.length;
        int i ,j;

        System.out.print("Original Array is : " );
        for ( i = 0; i < len; i++) {
            System.out.print(" " + elements[i]);
        }

        //loop for number of elements
        for(i = 0; i < len; i++)
        {
            //loop for sorting
            for(j = 0; j < len-1; j++)
            {
                if(elements[j] > elements[j+1])
                {
                    swap(j, j+1, elements);
                }
            }
        }

        System.out.print(" \nAfter Sorting the array is : " );
        for ( i = 0; i < len; i++) {
            System.out.print(" " + elements[i]);
        }
    }

    private static void swap(int i, int j, int [] elements) {
        int temp;
        // swap the elements
        temp = elements[j-1];
        elements[j-1] = elements[j];
        elements[j] = temp;
    }
}

