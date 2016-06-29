package com.L01DefiningClasses.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private Integer weight;
    private String colour;

    public Car(String model, Engine engine, Integer weight, String colour) {
        setModel(model);
        setEngine(engine);
        setWeight(weight);
        setColour(colour);
    }

    public Car(String model, Engine engine, Integer weight) {
        this(model, engine, weight, null);
    }

    public Car(String model, Engine engine, String colour) {
        this(model, engine, null, colour);
    }

    public Car(String model, Engine engine) {
        this(model, engine, null, null);
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        String output = String.format("%s:%n", getModel()) +
                getEngine().toString() +
                String.format("  Weight: %s%n", getWeight() == null ? "n/a" : getWeight().toString()) +
                String.format("  Color: %s%n", getColour() == null ? "n/a" : getColour());

        return output;
    }
}
