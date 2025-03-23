package com.cs.dsa.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciDP {
    // get the nth fibonacci series.
    private static int counter = 0;
    private static int counterDP = 0;

    Map<Integer, Integer> memo = new HashMap();

    public int getNthNumberOfFiboSeries(int n) {
        counter++;
        if(n <= 1) {
            return n;
        }
        return getNthNumberOfFiboSeries(n-1) + getNthNumberOfFiboSeries(n-2);
    }

    public int getNthNumberOfFiboSeriesDP(int n) {
        counterDP++;
        if(n <= 1) {
            return n;
        }
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = getNthNumberOfFiboSeriesDP(n-1) + getNthNumberOfFiboSeriesDP(n-2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        FibonacciDP fibonacciDP = new FibonacciDP();

        System.out.println("1st is : " + fibonacciDP.getNthNumberOfFiboSeries(1));
        System.out.println("3rd is : " + fibonacciDP.getNthNumberOfFiboSeries(3));
        System.out.println("4th is : " + fibonacciDP.getNthNumberOfFiboSeries(4));
        System.out.println("5th is : " + fibonacciDP.getNthNumberOfFiboSeries(6));

        System.out.println("Without DP (total), method called : " + counter);

        System.out.println("5th is : " + fibonacciDP.getNthNumberOfFiboSeriesDP(5));
        System.out.println("6th is : " + fibonacciDP.getNthNumberOfFiboSeriesDP(4));
        System.out.println("With DP (total), method called : " + counterDP);

    }
}
