package com.L03StaticMembers.AnimalClinic;

public class AnimalClinic {

    static int patientID = 0;
    static int healedAnimalsCount = 0;
    static int rehabilitedAnimalsCount = 0;

    public static int getHealedAnimalsCount() {
        return healedAnimalsCount;
    }

    public static int getRehabilitedAnimalsCount() {
        return rehabilitedAnimalsCount;
    }

    public static void heal(Animal animal) {
        patientID++;
        healedAnimalsCount++;
        System.out.printf("Patient %d: [%s (%s)] has been healed!%n",patientID,animal.getName(),animal.getBreed());
    }

    public static void rehabilitate(Animal animal) {
        patientID++;
        rehabilitedAnimalsCount++;
        System.out.printf("Patient %d: [%s (%s)] has been rehabilitated!%n",patientID,animal.getName(),animal.getBreed());
    }
}
