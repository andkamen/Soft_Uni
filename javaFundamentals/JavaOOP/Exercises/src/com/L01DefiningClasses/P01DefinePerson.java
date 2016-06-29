package com.L01DefiningClasses;

import com.L01DefiningClasses.CreateConstructor.Person;

import java.lang.reflect.Field;


public class P01DefinePerson {
    public static void main(String[] args) throws Exception {

        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}
