package com._02_SetsAndMaps;

import java.util.*;

public class _10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Long> countryPopulation = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> citiesData = new LinkedHashMap<>();

        String[] inputData = scan.nextLine().split("\\|");

        while (!inputData[0].equals("report")) {
            String city = inputData[0];
            String country = inputData[1];
            Long population = Long.parseLong(inputData[2]);

            if (!countryPopulation.containsKey(country)) {
                countryPopulation.put(country, population);
                citiesData.put(country, new LinkedHashMap<>());
            } else {
               long val = countryPopulation.get(country) + population;
                countryPopulation.put(country, val);
            }

            if (!citiesData.get(country).containsKey(city)) {
                citiesData.get(country).put(city, population);
            }
            inputData = scan.nextLine().split("\\|");
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> entry : citiesData.entrySet()) {
            entry.getValue().entrySet().stream().sorted(Map.Entry.comparingByValue());
        }

        countryPopulation.entrySet().stream().sorted((c1,c2)->c2.getValue().compareTo(c1.getValue())).forEach(country -> {
            System.out.printf("%s (total population: %d)%n",country.getKey(),country.getValue());

            citiesData.get(country.getKey()).entrySet().stream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue())).forEach(city ->
                    System.out.printf("=>%s: %d%n",city.getKey(),city.getValue()));


        });




        //System.out.print(0);
    }
}
