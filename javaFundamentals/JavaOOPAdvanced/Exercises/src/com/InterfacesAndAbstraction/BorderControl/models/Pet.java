package com.InterfacesAndAbstraction.BorderControl.models;

import com.InterfacesAndAbstraction.BorderControl.interfaces.Birthable;

public class Pet implements Birthable {

    private String name;
    private String birthdate;

    public Pet(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
    }
}
