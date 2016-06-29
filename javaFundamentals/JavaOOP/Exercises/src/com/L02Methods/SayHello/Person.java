package com.L02Methods.SayHello;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.printf("%s says \"Hello\"!",this.name);
    }
}
