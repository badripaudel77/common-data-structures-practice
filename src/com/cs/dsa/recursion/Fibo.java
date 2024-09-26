package com.cs.dsa.recursion;

public class Fibo {

    static void fibo(int n) {
        int a = 0, b = 1;
        int c = a + b;

        System.out.print("series for up to n = " + n + " is : "  + a + " " + b + " " );

        while (c < n) {
            System.out.print(c + " ");
            a = b;
            b = c;
            c = a + b;
        }
    }

    public static void main(String[] args) {
        fibo(15);
    }
}
