package com.L03StaticMembers.UniqueStudentNames;

import java.util.HashSet;

public class StudentGroup {
    private static HashSet<Student> students;
    private static int uniqueStudentsCount;

    public StudentGroup() {
        this.students = new HashSet<>();
    }

    public static int getUniqueStudentsCount() {
        return uniqueStudentsCount;
    }

    public static void addStudent(Student student){
        for (Student pupil : students) {
            if (pupil.getName().equals(student.getName())){
                return;
            }
        }

        students.add(student);
        uniqueStudentsCount++;
    }

}
