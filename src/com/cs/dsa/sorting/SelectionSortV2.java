package com.cs.dsa.sorting;

import java.util.Arrays;

/**
 * Find the minimum (or max) index, and swap it to the first element if they're in wrong order
 * And do similar for second and min (or max) element and so on.
 * Keep track of min / max element or index and compare the values
 *
 * Big Oh : O(n^2)
 */
public class SelectionSortV2 {

    private void selectionSort(int []items) {
        int len = items.length;
        for(int i = 0; i< len; i++) {
            int minIndex = i;
            for (int j = i+1; j < len; j++) {
                if(items[j] < items[minIndex]) {
                    minIndex = j;
                }
            }
            // swap element at min index, and at i
            if(i != minIndex) {
                swap(items, minIndex, i);
            }
        }
    }

    private void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    public static void main(String[] args) {
        int [] items = { 4,2,6,5,1,3 };

        Arrays.stream(items).forEach(i -> System.out.print(i + " "));
        SelectionSortV2 selectionSortV2 = new SelectionSortV2();
        selectionSortV2.selectionSort(items);
        System.out.println("After sorting (selection sort) => ");
        Arrays.stream(items).forEach(i -> System.out.print(i + " "));
    }
}
