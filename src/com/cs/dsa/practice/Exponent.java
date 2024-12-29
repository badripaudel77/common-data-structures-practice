package com.cs.dsa.practice;

public class Exponent {
    public int minMaxEqual(int a[]) {
        int len = a.length;
        if(len < 2) {
            return 0;
        }
        int max = a[0];
        int min = a[0];

        for(int num: a) {
            if(num > max) {
                max = num;
            }
            if(num < min) {
                min = num;
            }
        }
        if(max == min) {
            return 0;
        }
        int maxCount = 0;
        int minCount = 0;

        for(int n : a) {
            if(n == max) {
                maxCount++;
            }
            if(n == min) {
                minCount++;
            }
        }
        if(minCount == maxCount) {
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("Max Min Equal " + new Exponent().minMaxEqual(new int[]{}));
        System.out.println("Max Min Equal " + new Exponent().minMaxEqual(new int[]{2}));
        System.out.println("Max Min Equal " + new Exponent().minMaxEqual(new int[]{2,2}));
        System.out.println("Max Min Equal " + new Exponent().minMaxEqual(new int[]{2,1}));
        System.out.println("Max Min Equal " + new Exponent().minMaxEqual(new int[]{2,1, 1}));
        System.out.println("Max Min Equal " + new Exponent().minMaxEqual(new int[]{1, 1, 1, 1, 1, 1}));
        System.out.println("Max Min Equal " + new Exponent().minMaxEqual(new int[]{2, 4, 6, 8, 11}));
        System.out.println("Max Min Equal " + new Exponent().minMaxEqual(new int[]{-2, -4, -6, -8, -11}));
    }
}
