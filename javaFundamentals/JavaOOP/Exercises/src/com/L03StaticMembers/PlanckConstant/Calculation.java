package com.L03StaticMembers.PlanckConstant;

public class Calculation {
    private static final double PLANKS_CONSTANT = Double.valueOf("6.62606896e-34 ");
    private static final double PI = 3.14159;

    public static double reducedPlankConstant(){

        return PLANKS_CONSTANT / (2*PI);
    }
}
