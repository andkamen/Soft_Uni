package com.L02Methods.OldestFamilyMember;

import java.lang.reflect.Method;
import java.util.Scanner;

public class OldestFamilyMember {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());

        Family family = new Family();

        Method getOldestMethod = Family.class.getMethod("getOldestMember");
        Method addMemberMethod = Family.class.getMethod("addFamilyMember", Person.class);

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");

            String name = input[0];
            int age = Integer.valueOf(input[1]);
            family.addFamilyMember(new Person(name, age));

        }

        System.out.println(family.getOldestMember());
    }
}
