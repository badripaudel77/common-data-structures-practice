package com.cs.dsa.pretest.miu;

public class Frequency {
    private static int getFrequentNumber(int[] a) {
        int max = a[0];
        int maxCount = 0;
        int currentCount = 0;
        int len = a.length;

        if(len == 1 || len == 2) {
            return a[0];
        }

        for(int i = 0; i< len; i++) {
            for (int j = i+1; j < len; j++) {
                if(a[i] == a[j]) {
                    currentCount++;
                    if(currentCount > maxCount) {
                        maxCount = currentCount;
                        max = a[i];
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Frequent number is: " + getFrequentNumber(new int[]{6,8,1,8,2}));
        System.out.println("Frequent number is: " + getFrequentNumber(new int[]{6,1,8,2}));
        System.out.println("Frequent number is: " + getFrequentNumber(new int[]{6,1,8,2,2,2}));
        System.out.println("Frequent number is: " + getFrequentNumber(new int[]{6,1,1,8,2}));
    }
}
