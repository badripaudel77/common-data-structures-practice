package com.cs.dsa.pretest.miu;

public class MeeraArray {
    private static int isMeeraArray(int [] arr) {
        int isMeeraArray = 0;
        int len = arr.length;

        int left = 0;
        int right = len - 1;
        boolean isOneFound = false;
        boolean isNineFound = false;

        while(left <= right) {
            if((arr[left] == 1 || arr[right] == 1)) {
                isOneFound = true;
            }
            if(arr[left] == 9 || arr[right] == 9) {
                isNineFound = true;
            }
            left++;
            right--;
        }
        if((isOneFound && isNineFound) || (!isOneFound && !isNineFound)) {
            isMeeraArray = 1;
        }
        return isMeeraArray;
    }

    public static void main(String[] args) {
        System.out.println("Is Meera Array: " + isMeeraArray(new int[] {1,2,3,4,5,5,6}));
        System.out.println("Is Meera Array: " + isMeeraArray(new int[] {1,2,3,4,5,5,6, 9}));
        System.out.println("Is Meera Array: " + isMeeraArray(new int[] {7,9,0,10,1}));
        System.out.println("Is Meera Array: " + isMeeraArray(new int[] {6,10,8}));
        System.out.println("Is Meera Array: " + isMeeraArray(new int[] {9,10,0}));
        System.out.println("Is Meera Array: " + isMeeraArray(new int[] {9,10,0}));
    }
}
