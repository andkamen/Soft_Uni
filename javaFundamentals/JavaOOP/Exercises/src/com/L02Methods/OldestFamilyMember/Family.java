package com.L02Methods.OldestFamilyMember;

import java.util.ArrayList;

public class Family {
    private ArrayList<Person> family;

    public Family() {
        this.family = new ArrayList<>();
    }

    public void addFamilyMember(Person member){
        this.family.add(member);
    }

    public Person getOldestMember(){
        return family.stream().sorted((m1, m2) -> Integer.compare(m2.getAge(),m1.getAge())).findFirst().get();
    }
}
