package com.cs.dsa.comparator;

/*
 * It's java specific, comparator, comparable to compare especially some objects type for example
 */

//public class Student implements Comparator<Student> { // if comparator implement compare(....) if comparable implements compareTo(..)
public class Student implements Comparable<Student> {
    private String name;
    private Integer roll;

    public Student(String name, Integer roll) {
        this.name = name;
        this.roll = roll;
    }

    public Student() {
        this("Default Student", 0);
    }

    // compare two Students using comparable or comparator

    @Override
    public int compareTo(Student o) {
       boolean isNotZero =  o.roll != 0;
       if(isNotZero) return o.roll;
       else return -1;
    }


    // @Override
   // public int compare(Student o1, Student o2) {
   //     System.out.print("Compare Method = ");
   //     return (o1.roll - o2.roll);
   // }

    @Override
    public String toString() {
        return "Student = { " + "name='" + name + '\'' + ", roll=" + roll + " }";
    }

    public static void main(String[] args) {
        Student studentDefault = new Student(); // invoke default constructor which initializes default values
        // by passing to parameterized constructor using this(..);
        System.out.println(studentDefault);
        Student studentBadri = new Student("Badri Paudel", 16666645);
        System.out.println(studentBadri);
       // Integer differenceOfRoll = studentDefault.compare(studentBadri, studentDefault);
       // System.out.println("Difference in Roll Number = " + differenceOfRoll);
       Integer differenceRoll = studentBadri.compareTo(studentDefault);
        Integer differenceRoll_ = studentBadri.compareTo(studentBadri);

        System.out.println("\nDifference = " + differenceRoll);
        System.out.println("Difference = " + differenceRoll_);

    }
}
