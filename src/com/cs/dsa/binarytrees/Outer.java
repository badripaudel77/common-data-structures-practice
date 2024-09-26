package com.cs.dsa.binarytrees;

public class Outer {
    private int outer;

    public Outer() {}

    public Outer(int outer) {
        this.outer = outer;
    }

    public void calculate() {
        System.out.println("Outer is : " + this.outer);
        System.out.println("Inner is " + new Inner(9).getInner());
    }

    public class Inner {
        private int inner;

        public Inner() {}

        public Inner(int inner) {
            this.inner = inner;
        }

        public int getInner() {
            return this.inner;
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer(10);
        outer.calculate();

        Outer.Inner inner = outer.new Inner(); // If Inner is static, can do new Inner() as non-static can't be referenced from static context.
        System.out.println(inner.getInner());
    }
}
