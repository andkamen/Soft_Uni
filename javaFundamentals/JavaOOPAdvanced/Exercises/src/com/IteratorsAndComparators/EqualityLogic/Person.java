package com.IteratorsAndComparators.EqualityLogic;

import java.util.regex.Pattern;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 1 || name.length() > 50) {
            throw new IllegalArgumentException("Invalid name length");
        }
        if (!Pattern.compile("\\w+").matcher(name).find()) {
            throw new IllegalArgumentException("Invalid name characters");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1 || age > 100) {
            throw new IllegalArgumentException("Invalid age!");
        }
        this.age = age;
    }

    @Override
    public int hashCode() {
        int result = this.name != null ? this.name.hashCode() : 0;
        result = 331 * result + this.age;
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Person))
            return false;
        if (other == this)
            return true;

        Person person = (Person) other;

        return this.getAge() == person.getAge() && this.getName().equals(person.getName());
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.hashCode(), other.hashCode());
    }
}
