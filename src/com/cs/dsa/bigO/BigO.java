package com.cs.dsa.bigO;

public class BigO {

    public static void main(String[] args) {

        int arr[] = {3,4,5};

        BigO1 bigO1 = new BigO1();
        bigO1.bigO1(arr);

        BigOn bigOn = new BigOn();
        bigOn.bigOn(arr);

        BigOn2 bigOn2 = new BigOn2();
        bigOn2.bigOn2(arr);

    }
}

class BigO1 extends Object {
    public void bigO1( int [] numbers ) {
        System.out.println("Big O of 1 : O(n)");
        //O(1) as always the same complexity no matter of the inputs and size
        if(numbers.length>0) System.out.println(numbers[0]);
    }
}

class BigOn extends Object {
    public void bigOn( int [] numbers ) {
        System.out.println("Big O of n : O(n)");
        //O(n) as input size matters for the function to give output
        for(int num : numbers) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }
}

class BigOn2 extends Object {
    public void bigOn2( int [] numbers ) {
        //Here we're nesting two loops.
        //If our array has n items, our outer loop runs n times and
        //our inner loop runs n times for each iteration of the outer loop,
        //giving us n2 total prints. Thus this function runs in O(n^2) times (or "quadratic times").
        //If the array has 10 items, we have to print 100 times.
        //If it has 1000 items, we have to print 1000000 times.

        System.out.println("Big O of n^2 : O(n^2) ");
        // O(n)
        for(int num1 : numbers) {
            //O(n)
            for(int num2 : numbers) {
                System.out.printf("%d %d ", num1, num2);
            }
        }
    }
}
