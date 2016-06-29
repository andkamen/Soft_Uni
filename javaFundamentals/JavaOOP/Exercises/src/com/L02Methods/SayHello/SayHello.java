package com.L02Methods.SayHello;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class SayHello {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Field[] fields = Person.class.getDeclaredFields();
        Method[] methods = Person.class.getDeclaredMethods();
        if (fields.length != 1 || methods.length != 1) {
            throw new ClassFormatError();
        }

        Person person = new Person(scan.nextLine());
        person.sayHello();

    }
}

