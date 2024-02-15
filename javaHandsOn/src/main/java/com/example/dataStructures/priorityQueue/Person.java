package com.example.dataStructures.priorityQueue;

public class Person implements Comparable<Person> {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
    The compareTo method tells us when to swap the position of 2 objects
     */
    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age,o.age);
    }
}
