package com.L03StaticMembers.UniqueStudentNames;

public class Student {
    private static String name;

    public Student(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

}
