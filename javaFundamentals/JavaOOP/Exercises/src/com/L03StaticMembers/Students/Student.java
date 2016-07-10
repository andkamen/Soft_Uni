package com.L03StaticMembers.Students;

public class Student {
    private String name;
    private static Integer studentCount=0;

    public Student(String name) {
        setName(name);
        studentCount++;
    }
    private void setName(String name) {
        this.name = name;
    }

    public static Integer getStudentCount() {
        return studentCount;
    }
}
