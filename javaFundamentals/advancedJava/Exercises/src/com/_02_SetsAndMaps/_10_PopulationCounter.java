package com._02_SetsAndMaps;

import java.util.*;

public class _10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Integer> countryPopulation = new LinkedHashMap<>();
        HashMap<String, LinkedHashMap<String, Integer>> citiesData = new HashMap<>();

        String[] inputData = scan.nextLine().split("\\|");

        while (!inputData[0].equals("report")) {
            String city = inputData[0];
            String country = inputData[1];
            Integer population = Integer.parseInt(inputData[2]);

            if (!countryPopulation.containsKey(country)) {
                countryPopulation.put(country, population);
                citiesData.put(country, new LinkedHashMap<>());
            } else {
                int val = countryPopulation.get(country) + population;
                countryPopulation.put(country, val);
            }

            if (!citiesData.get(country).containsKey(city)) {
                citiesData.get(country).put(city, population);
            }
            inputData = scan.nextLine().split("\\|");
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : citiesData.entrySet()) {
            entry.getValue().entrySet().stream().sorted(Map.Entry.comparingByValue());
        }

//        countryPopulation.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue())
//                .forEach(country -> {
//                    System.out.printf("%s (total population: %d)%n", country.getKey(),country.getValue());
//                    for (Map.Entry<String,Integer> city : citiesData.get(country.getKey())) {
//
//                    }
//                    for (Object o : citiesData.get(country.getKey())) {
//
//                    }
//
//
//                });

        System.out.print(1);
    }
}
