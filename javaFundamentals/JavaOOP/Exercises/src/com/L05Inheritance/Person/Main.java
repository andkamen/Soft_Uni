package com.L05Inheritance.Person;

import com.L05Inheritance.Person.models.Child;
import com.L05Inheritance.Person.models.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int age = Integer.valueOf(reader.readLine());

        try{
            Child child = new Child(name, age);
            System.out.println(child.toString());
            String personClassName = Person.class.getSimpleName();
            String childClassName = Child.class.getSimpleName();
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}