package com.L03StaticMembers.AnimalClinic;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

import static com.L03StaticMembers.AnimalClinic.AnimalClinic.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Animal> healedAnimals = new ArrayList<>();
        ArrayList<Animal> rehabilitatedAnimals = new ArrayList<>();

        while(true) {
            String[] input = scan.nextLine().split("\\s+");
            if (input[0].equals("End")) {
                break;
            }
            String name = input[0];
            String breed = input[1];
            String treatment = input[2];

            Animal animal = new Animal(name,breed);

            if(treatment.equals("heal")){
                heal(animal);
                healedAnimals.add(animal);
            }else{
                rehabilitate(animal);
                rehabilitatedAnimals.add(animal);
            }
        }
        System.out.printf("Total healed animals: %d%n",getHealedAnimalsCount());
        System.out.printf("Total rehabilitated animals: %d%n",getRehabilitedAnimalsCount());

        String infoToPrint = scan.nextLine();
        if (infoToPrint.equals("heal")){
            for (Animal animal : healedAnimals) {
                System.out.printf("%s %s%n",animal.getName(), animal.getBreed());
            }
        }else{
            for (Animal animal : rehabilitatedAnimals) {
                System.out.printf("%s %s%n",animal.getName(), animal.getBreed());
            }
        }
    }
}
