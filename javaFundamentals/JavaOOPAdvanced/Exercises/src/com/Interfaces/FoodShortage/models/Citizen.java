package com.Interfaces.FoodShortage.models;

import com.Interfaces.FoodShortage.interfaces.Buyer;

public class Citizen implements Buyer {
    private String name;
    private int age;
    private String id;
    private String birthdate;
    private int food;

    public Citizen(String name, int age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
    }

    @Override
    public int getFoodAmount() {
        return this.food;
    }

    @Override
    public void BuyFood() {
        this.food+=10;
    }
}
