package com.cs.dsa.sorting;

/*
[ follows recursion approach ]

Merge sort is a sorting technique based on divide and conquer technique.
With worst-case time complexity being Ο(n log n), it is one of the efficient algorithms.

low, high, middle = ( low + high ) /2

recursively divide the array till it has atomic value.

Step 1 − if it is only one element in the list it is already sorted, return.
Step 2 − divide the list recursively into two halves until it can no more be divided.
Step 3 − merge the smaller lists into new list in sorted order.

 ref  : https://www.studytonight.com/data-structures/merge-sort

 */

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr [] = { 12,3,5,1,-5 };
        int len = arr.length;

        int begin = arr[0];
        int end = arr[len -1];

        System.out.println("Before sorting : " + Arrays.toString(arr));

        sort(arr, begin, end);
        System.out.println("After sorting : " + Arrays.toString(arr));

    }

    private static void sort(int [] arr, int begin, int end) {
        int mid ;

        if(begin < end) {
            mid = (begin + end) / 2;

            sort(arr, begin, mid); // recursively divide half left to mid
            sort(arr, mid + 1, end); // recursively divide half right to mid

            //finally merge them in to one final array
            merge(arr, begin, mid, end);
        }

    }

    //write the logic to merge those sub-arrays divided earlier.
    private static void merge(int[] arr, int begin, int mid, int end) {

    }
}
