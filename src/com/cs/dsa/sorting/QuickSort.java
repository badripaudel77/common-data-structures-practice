package com.cs.dsa.sorting;

import java.util.Arrays;

/*
    It's one of the efficient algorithms [ as it follows divide and  conquer approach to solve the problem ]
    Quick sort follows divide and conquer approach [ recursive function calls ]

      1) We have pivot element, central element ( generally rightmost element[last element] ) ,
         Less than pivot [to the left sub-array] and greater than pivot to the right sub-array.
      2) Partition the element such that elements at the left of pivot element are smaller and to the right are greater.

      while(start < end) {
       partition(Arr, start, end); //finding the pivot element to get number 2.
       sortLeft(Arr, start, pivotPostion-1)
       sortRight(Arr, pivotPostion+1, end)

      }

      partition(A, st, end) {
        //write the logic to push all the elements smaller than the pivot to the left so that greater than pivot will be to the right automatically.
      }

  */
// Quick sort in Java

import java.util.Arrays;

class QuickSort {

    int partition(int array[], int low, int high) {

        // choose the pivot element as the rightmost element
        int pivot = array[high];
        int pIndex = low;

        // Put the elements smaller than pivot on the left and
        // greater than pivot on the right of pivot
        for (int j = low; j <= high-1; j++) {
            if (array[j] <= pivot) {
                int temp = array[pIndex];
                array[pIndex] = array[j];
                array[j] = temp;
                pIndex ++;
            }
        }
        //swap the pivot and higher index elements
        int temp = array[pIndex];
        array[pIndex] = array[high];
        array[high] = temp;
        return pIndex;
    }

    void quickSort(int array[], int low, int high) {

        //exit condition
        if (low >= high) return;

            // Select pivot position and put all the elements smaller
            // than pivot on left and greater than pivot on right
            int pIndex = partition(array, low, high);

            // Sort the elements on the left of pivot
            quickSort(array, low, pIndex - 1);

            // Sort the elements on the right of pivot
            quickSort(array, pIndex + 1, high);
    }

    // Driver code
    public static void main(String args[]) {
        int[] elements = { 1,4,-9,0,6,-12 };
        int len = elements.length;
        QuickSort sort = new QuickSort();
        System.out.println("Before  sorting : " + Arrays.toString(elements));
        sort.quickSort(elements, 0, len - 1);
        System.out.println("After   sorting : " + Arrays.toString(elements));

    }

}
