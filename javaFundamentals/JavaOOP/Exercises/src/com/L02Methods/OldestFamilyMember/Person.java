package com.L02Methods.OldestFamilyMember;

public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
       return String.format("%s %d",getName(),getAge());
    }
}