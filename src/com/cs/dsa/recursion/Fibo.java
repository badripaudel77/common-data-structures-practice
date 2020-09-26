package com.cs.dsa.recursion;

public class Fibo {

    static int fibo(int n) {
        System.out.print("series for up to n = " + n + " is : "  );
        int a = 0;
        int b = 1;
        int c = a + b;

        System.out.print(a + " " + b + " ");

        while (c < n) {
            System.out.print(c + " ");
            a = b;
            b = c;
            c = a + b;
        }
        return 0;
    }

    public static void main(String[] args) {
        fibo(5);
    }
}
