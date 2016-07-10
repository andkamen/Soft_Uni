package com.L02Methods.RectangleIntersection;

public class Rectangle {
    private String name;
    private double width;
    private double height;
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    public Rectangle(String name, double width, double height, double topLeftX, double topLeftY) {
        this.setName(name);
        this.setWidth(width);
        this.setHeight(height);
        this.setX1(topLeftX);
        this.setY1(topLeftY);
        this.setX2(getX1() + getWidth());
        this.setY2(getY1() + getHeight());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double topLeftX) {
        this.x1 = topLeftX;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double topLeftY) {
        this.y1 = topLeftY;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public boolean intersects(Rectangle other) {
        return this.getX1() <= other.getX2() &&
                other.getX1() <= this.getX2() &&
                this.getY1() <= other.getY2() &&
                other.getY1() <= this.getY2();
    }
}
