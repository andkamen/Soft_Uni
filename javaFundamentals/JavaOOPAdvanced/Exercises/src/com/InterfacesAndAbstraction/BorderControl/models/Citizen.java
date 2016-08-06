package com.InterfacesAndAbstraction.BorderControl.models;

import com.InterfacesAndAbstraction.BorderControl.interfaces.Birthable;
import com.InterfacesAndAbstraction.BorderControl.interfaces.Identifiable;

public class Citizen implements Identifiable,Birthable {

    private String name;
    private int age;
    private String id;
    private String birthdate;

    public Citizen(String name, int age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }
}
