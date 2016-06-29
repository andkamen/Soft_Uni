package com.L01DefiningClasses.PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Trainer> trainersData = new LinkedHashMap<>();


        while (true) {
            String[] parameters = reader.readLine().split("\\s+");
            if (parameters[0].equals("Tournament")) {
                break;
            }
            if (!trainersData.containsKey(parameters[0])) {
                Trainer trainer = new Trainer(parameters[0]);
                trainer.addPokemon(new Pokemon(parameters[1], parameters[2], Integer.valueOf(parameters[3])));
                trainersData.put(trainer.getName(), trainer);
            } else {
                trainersData.get(parameters[0]).addPokemon(new Pokemon(parameters[1], parameters[2], Integer.valueOf(parameters[3])));
            }
        }

        while (true) {
            String input = reader.readLine();
            if (input.equals("End")) {
                break;
            }
            for (Trainer trainer : trainersData.values()) {
                trainer.updateTrainer(input);
            }
        }

        trainersData.entrySet().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getBadgeCount(),t1.getValue().getBadgeCount()))
                .forEach(entry ->{
                    System.out.printf("%s %d %d%n",entry.getKey(),entry.getValue().getBadgeCount(),entry.getValue().getPokemonCount());
                });
    }
}
