package com.cs.dsa.pretest.miu;

public class FancyNumber {

    private static int isFancy(int number) {
        int first = 1;
        int second = 1;
        int third = 3 * first + 2 * first;

        while(third < number) {
            third = 3 * second + 2 * first;
            first = second;
            second = third;
        }

        if(number == third) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Is Fancy : " + isFancy(5));
        System.out.println("Is Fancy : " + isFancy(17));
        System.out.println("Is Fancy : " + isFancy(18));
        System.out.println("Is Fancy : " + isFancy(61));
        System.out.println("Is Fancy : " + isFancy(613));
        System.out.println("Is Fancy : " + isFancy(62));
    }
}
