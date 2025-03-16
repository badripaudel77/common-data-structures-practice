package com.cs.dsa.sorting;

import java.util.Arrays;

/**
 * Starts from the 1st index, and compare it with the previous element and swap them (insert the min value ...).
 * If element is at nth index, compare it while it is smaller (or greater depending on asc or desc sort) and move
 * it all the way to the correct position
 * For best case scenario, when array is almost sorted, it will have time complexity of O(n), then inner loop will not be executed.
 */
public class InsertionSortV2 {

    private void selectionSort(int[] items) {
        int len = items.length;

        for(int i = 1; i<len; i++) {
            int currentValue = items[i];
            int j = i-1;

            while(j >= 0 && currentValue < items[j]) {
                items[j+1] = items[j];
                items[j] = currentValue;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int [] items = { 4,2,6,5,1,3 };

        int[] items2 = new int[] { -1, -5, 3,7,8,9 };

        Arrays.stream(items).forEach(i -> System.out.print(i + " "));
        InsertionSortV2 insertionSortV2 = new InsertionSortV2();
        insertionSortV2.selectionSort(items);
        System.out.println("After sorting (insertion sort) => ");
        Arrays.stream(items).forEach(i -> System.out.print(i + " "));

        insertionSortV2.selectionSort(items2);
        System.out.println("After sorting negative values: ");
        Arrays.stream(items2).forEach(i -> System.out.print(i + " "));

    }
}
