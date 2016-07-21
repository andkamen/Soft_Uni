package com.Interfaces.BorderControl;

import com.Interfaces.BorderControl.interfaces.Birthable;
import com.Interfaces.BorderControl.models.Citizen;
import com.Interfaces.BorderControl.models.Pet;
import com.Interfaces.BorderControl.models.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashSet<Birthable> citizensAndPets = new LinkedHashSet<>();

        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if (input[0].equals("End")) {
                break;
            }
            switch (input[0]){
                case "Citizen":
                    Citizen citizen = new Citizen(input[1], Integer.parseInt(input[2]), input[3], input[4]);
                    citizensAndPets.add(citizen);
                    break;
                case "Pet":
                    Pet pet = new Pet(input[1],input[2]);
                    citizensAndPets.add(pet);
                    break;
                default:
                    break;
            }
        }

        String year = reader.readLine();

        citizensAndPets.stream().filter(c -> c.getBirthdate().endsWith(year)).forEach(c -> System.out.println(c.getBirthdate()));
    }
}
