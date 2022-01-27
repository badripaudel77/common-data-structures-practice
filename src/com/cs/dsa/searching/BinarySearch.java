package com.cs.dsa.searching;
/*
  Binary Search is done on the sorting array. Its complexity is O(log n).
  Follows " Divide and conquer " approach.

  steps :
        1) Find the middle element, if that is the target element, just return that element, middleIndex = lower + (upper - lower)/2
        2) If target element is > than middle then see the right part of the array [list] else left part and do step 1
        3) If match is found just return index or element else return -1
*/

import java.util.Arrays;

public class BinarySearch extends  Object{

    public BinarySearch() {}

    public static void main(String[] args) {

        int elements[] = { 12, 34, 45,77 };
        int elementToSearch = 77;

        System.out.print("Original Array is "+ Arrays.toString(elements));
        searchElement(elements, elementToSearch);
    }

    //binary search
    public  static void searchElement(int [] elements, int elementToSearch) {

        //elements is a sorted array as it has to be sorted.
        int lenOfElements = elements.length;
        int i;
        int noOfItrToFindElem = 0;
        Integer index = null;
        Integer middleIndex = null;
        int stepsToFindElem = 0;

        int firstIndex = 0;
        int lastIndex = lenOfElements -1;

        if(lenOfElements <= 0) {
            System.out.println("\nPlease provide some elements");
            return;
        }

        while (lastIndex >= firstIndex) {

            stepsToFindElem ++;

            middleIndex = firstIndex + (lastIndex- firstIndex) /2;

            if(elements[middleIndex] == elementToSearch) {
                index = middleIndex;
                System.out.println("\nElement found at  index "+ index + " at " + stepsToFindElem + " steps.");
                return;
            }
            if(elements[middleIndex] > elementToSearch) {
                //element is in left half so decrease the upper bound
                lastIndex = lastIndex -1;
            }

            if(elements[middleIndex] < elementToSearch) {
               //element is in the right half so increase the lower bound
                firstIndex = firstIndex + 1;
            }
        }
    }
}
