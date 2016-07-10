package com.L03StaticMembers.ShapesVolume;

public class TriangularPrism {

    private double base;
    private double height;
    private double length;

    public TriangularPrism(double base, double height, double length) {
        this.base = base;
        this.height = height;
        this.length = length;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }
}
