package com.L01DefiningClasses.CarSalesman;

public class Engine {

    private String model;
    private Integer power;
    private Integer displacement;
    private String efficiency;

    public Engine(String model, Integer power, Integer displacement, String efficiency) {
        setModel(model);
        setPower(power);
        setDisplacement(displacement);
        setEfficiency(efficiency);
    }

    public Engine(String model, Integer power, Integer displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, Integer power, String efficiency) {
        this(model, power, null, efficiency);
    }

    public Engine(String model, Integer power) {
        this(model, power, null, null);
    }

    public Integer getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Integer displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }


    @Override
    public String toString() {
        String output = String.format("  %s:%n", getModel()) +
                String.format("    Power: %d%n", getPower()) +
                String.format("    Displacement: %s%n", getDisplacement() == null ? "n/a" : getDisplacement().toString()) +
                String.format("    Efficiency: %s%n", getEfficiency() == null ? "n/a" : getEfficiency());

        return output;
    }
}
