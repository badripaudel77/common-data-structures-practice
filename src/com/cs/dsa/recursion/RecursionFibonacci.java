package com.cs.dsa.recursion;

public class RecursionFibonacci {

    public static void main(String[] args) {
        int n = 5;
        System.out.print(" for n = "  + n + " series is : ");

        for(int i = 2; i< n; i++) {
            System.out.print(recursionFibonacci(i) + "   ");
        }
    }

    private  static int recursionFibonacci(int n) {

        switch (n) {
            case 0 :
                return 0;

            case 1 :
                return 1;

            default:
                return  recursionFibonacci(n-1) + recursionFibonacci(n -2);
        }
    }
}
