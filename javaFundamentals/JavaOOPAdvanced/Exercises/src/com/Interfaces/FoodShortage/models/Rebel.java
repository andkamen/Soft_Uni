package com.Interfaces.FoodShortage.models;

import com.Interfaces.FoodShortage.interfaces.Buyer;

public class Rebel implements Buyer {
    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public int getFoodAmount() {
        return this.food;
    }

    @Override
    public void BuyFood() {
        this.food+=5;
    }
}
