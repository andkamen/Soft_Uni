package com.InterfacesAndAbstraction.FoodShortage;

import com.InterfacesAndAbstraction.FoodShortage.interfaces.Buyer;
import com.InterfacesAndAbstraction.FoodShortage.models.Citizen;
import com.InterfacesAndAbstraction.FoodShortage.models.Rebel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Buyer> people = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            if (input.length == 4) {
                Citizen citizen = new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]);
                people.put(input[0], citizen);
            }
            if (input.length==3){
                Rebel rebel = new Rebel(input[0],Integer.parseInt(input[1]), input[2]);
                people.put(input[0],rebel);
            }
        }
        while (true) {
            String name = reader.readLine();
            if (name.equals("End")) {
                break;
            }

            if (people.containsKey(name)){
                people.get(name).BuyFood();
            }
        }

        int totalFood = people.values().stream().mapToInt(Buyer::getFoodAmount).sum();
        System.out.println(totalFood);
    }
}
