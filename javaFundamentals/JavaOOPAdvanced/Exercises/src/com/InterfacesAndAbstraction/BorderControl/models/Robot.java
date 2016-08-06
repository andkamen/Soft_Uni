package com.InterfacesAndAbstraction.BorderControl.models;

import com.InterfacesAndAbstraction.BorderControl.interfaces.Identifiable;

public class Robot implements Identifiable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
