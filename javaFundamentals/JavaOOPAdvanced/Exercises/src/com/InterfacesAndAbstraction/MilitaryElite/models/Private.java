package com.InterfacesAndAbstraction.MilitaryElite.models;

import com.InterfacesAndAbstraction.MilitaryElite.interfaces.IPrivate;

public class Private extends Soldier implements IPrivate {

    private double salary;

    public Private(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format(" Salary: %.2f", this.getSalary()));
        return sb.toString();
    }
}
