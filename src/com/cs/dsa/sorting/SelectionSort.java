package com.cs.dsa.sorting;
/*
   In selection sort we take one element that is min or max and sort it first from others.

   Assume sorting in ASC fashion,
   steps:
        1) Find the smallest item in the array and place it in the first position.
        2) Then find the second smallest item in the array and place it in the second position and so on...
        3) Called selection sort because it "selects" the smallest element in the array.

   complexity of 0(n^2)

 */

 class SelectionSort {
    public static void main(String[] args) {

        int elements[] = {45, 36, 12, -1, 0};

        var sort = new SelectionSortTest();
        sort.sortElements(elements);
    }
}

  class SelectionSortTest {

    //sorting elem
    public  void sortElements(int [] elements) {
        var len  = elements.length;
        int i ,j;
        int minIndex;

        System.out.print("Original Array is : " );
        for ( i = 0; i < len; i++) {
            System.out.print(" " + elements[i]);
        }

        //loop for number of elements
        for(i = 0; i < len-1; i++)
        {
            //set minimum index to the current element.
            minIndex = i;

            for(j = i +1; j< len; j++) {
                if(elements[j] < elements[minIndex]) {
                    //set lowest index = j
                    minIndex = j;
                }
            }
            int minValue = elements[minIndex];
            elements[minIndex] = elements[i];
            elements[i] = minValue;
        }

        System.out.print(" \nAfter Sorting the array is : " );
        for ( i = 0; i < len; i++) {
            System.out.print(" " + elements[i]);
         }
     }
  }


