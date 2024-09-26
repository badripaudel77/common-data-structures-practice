package com.cs.dsa.recursion;

 /*
     Power rules :
                  pow(n,0) = n^0 = 1 [n = number Any base raise to the power of 0 is always 1 ]
                  pow(n,1) = n^1 = n [ any base raise to the power of  1 is number itself ]

                  pow(n,-m) = n^-m = 1 / n^m

 */

public class MathPower {
    public static void main(String[] args) {

        int base = 5;
        int power = -2;

        float result = calcPower(base,power);
        System.out.println(base + " raise to the power of " + power + " = " + result);
    }

    public static float calcPower(int base, int exp) {

        //recursion stopping condition
        if(exp == 0) return 1;

        else if(exp == 1) return base;

        else if(exp == -1) return   (float) 1 / base;

        else  if(exp < 0) return  (float) 1 / calcPower(base, (-1) * exp);

        return base * calcPower(base, exp -1);
    }
}


