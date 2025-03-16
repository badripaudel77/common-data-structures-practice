package com.cs.dsa.sorting;

import java.util.Arrays;

/**
 * Bubble up the highest or lowest value to the end/first position.
 * For one element to be bubbled up, it will need n-1 passes,
 * Similarly, n-2 passes and so on.
 *
 * BigO of this : O(n^2)
 */
public class BubbleSortV2 {

    private void bubbleSort(int[] items) {
        int len = items.length;

        for(int i = 0; i< len; i++) {
            for(int j = 1; j< len; j++) {
                if(items[j-1] > items[j]) {
                    swap(items, j-1, j);
                }
            }
        }
    }

    public void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public static void main(String[] args) {
        int [] items = { 4,2,6,5,1,3 };

        Arrays.stream(items).forEach(i -> System.out.print(i + " "));
        BubbleSortV2 bubbleSortV2 = new BubbleSortV2();
        bubbleSortV2.bubbleSort(items);
        System.out.println("After sorting (bubble sort) => ");
        Arrays.stream(items).forEach(i -> System.out.print(i + " "));
    }
}
