package com.practice.design.patterns;

/**
 * This code is to demonstrate singleton design pattern.
 */
class Person {
    // some common fields
    String country;

    //1.  make private static instance field, so that it will be shared globally and only once.
    private static Person person;

    // 2. Private constructor to prevent external instantiation
    private Person() {
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    // public static method to access single instance of a person
    public static Person getPersonInstance() {
       if(person == null) {
           person = new Person();
       }
       return person;
    }
}
public class SingletonApp {
    public static void main(String[] args) {
       //  Person person = new Person(); // error as constructor is private to achieve singleton pattern.
        Person person = Person.getPersonInstance();
        person.setCountry("Nepal");
        System.out.println("Person's country is >>> " + person.getCountry());
    }
}
