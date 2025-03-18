package com.cs.dsa.sorting;

/*
[ follows recursion approach ]

Merge sort is a sorting technique based on divide and conquer technique.
With worst-case time complexity being Ο(n log n), it is one of the efficient algorithms.

low, high, middle = ( low + high ) /2

Recursively divide the array till it has atomic value.

Step 1 − If it is only one element in the list it is already sorted, return.
Step 2 − Divide the list recursively into two halves until it can no more be divided.
Step 3 − Merge the smaller lists into new list in sorted order.

Divide > Conquer > Combine

Ref : https://www.studytonight.com/data-structures/merge-sort

 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr [] = { 12,3,5,1,-5, -5, -4, 12, 15 };

        System.out.println("Before sorting : " + Arrays.toString(arr));
        int[] sortedArray = mergeSort(arr);
        System.out.println("After sorting : " + Arrays.toString(sortedArray));
    }

    // Divide the array into, atomic elements
    private static int[] mergeSort(int[] arr) {
            int len = arr.length;
            if(len <= 1) {
                return arr;
            }
            int mid = len / 2;
            int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid)); // recursively divide half left to mid
            int[] right = mergeSort(Arrays.copyOfRange(arr, mid, len)); // recursively divide half right to mid

            // Finally, merge them in to one final array
            return merge(left, right);
    }

    // Write the logic to merge those sub-arrays divided earlier.
    // Takes two sorted arrays and merge them together
    private static int[] merge(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int index = 0;

        // Now while this case is valid, compare the element and put that in the merged array.
        while (i < arr1.length && j < arr2.length) {
            // Case 1: When element of the first array is smaller than the second array, put its element in the combined array and increment positions
            if(arr1[i] < arr2[j]) {
                mergedArray[index++] = arr1[i++];
            }

            // Case 2: When element of the second array is smaller than the first array, put its element in the combined array and increment positions
            else {
                mergedArray[index++] = arr2[j++];
            }
        }
        // For remaining elements
        // Case 3: Put the leftover elements of first array if any
        while(i < arr1.length) {
            mergedArray[index++] = arr1[i++];
        }
        // Case 4: Put the leftover elements of second array if any
        while(j < arr2.length) {
            mergedArray[index++] = arr2[j++];
        }
        return mergedArray;
    }
}
