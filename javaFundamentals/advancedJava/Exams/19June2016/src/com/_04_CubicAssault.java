package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class _04_CubicAssault {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, LinkedHashMap<String, Long>> regionData = new LinkedHashMap<>();

        String[] inputData = reader.readLine().split(" -> ");

        while (!inputData[0].equals("Count em all")) {

            String region = inputData[0];
            String type = inputData[1];
            Integer amount = Integer.parseInt(inputData[2]);

            if (!regionData.containsKey(region)) {
                regionData.put(region, new LinkedHashMap<>());
                regionData.get(region).put("Black", 0l);
                regionData.get(region).put("Red", 0l);
                regionData.get(region).put("Green", 0l);
            }

            Long val = regionData.get(region).get(type) + amount;
            regionData.get(region).put(type, val);
            for (Map.Entry<String, LinkedHashMap<String, Long>> regionEntry : regionData.entrySet()) {
                Long greenCount = regionEntry.getValue().get("Green");
                if (greenCount >= 1_000_000) {
                    Long combineCount = greenCount / 1_000_000;
                    Long redCount = regionEntry.getValue().get("Red");
                    regionEntry.getValue().replace("Red", combineCount + redCount);
                    regionEntry.getValue().replace("Green", greenCount % 1_000_000);
                }

                long redCount = regionEntry.getValue().get("Red");
                if (redCount >= 1_000_000) {
                    Long combineCount = redCount / 1_000_000;
                    Long black = regionEntry.getValue().get("Black");
                    regionEntry.getValue().replace("Black", combineCount + black);
                    regionEntry.getValue().replace("Red", redCount % 1_000_000);
                }
            }

            inputData = reader.readLine().split(" -> ");
        }

        

        LinkedHashMap<String, LinkedHashMap<String, Long>> orderedRegions = new LinkedHashMap<>();

        orderedRegions = regionData.entrySet().stream().sorted((e1, e2) -> {

            int result = e2.getValue().get("Black").compareTo(e1.getValue().get("Black"));
            if (result == 0) {
                result = Integer.compare(e1.getKey().length(),e2.getKey().length());

                if (result == 0) {
                    result = e1.getKey().compareTo(e2.getKey());
                }
            }
            return result;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> {throw new AssertionError();}, LinkedHashMap::new));

        for (Map.Entry<String, LinkedHashMap<String, Long>> entry : orderedRegions.entrySet()) {

            System.out.println(entry.getKey());
            LinkedHashMap<String, Long> sortedEntry = entry.getValue().entrySet().stream().sorted((e1, e2)-> {
                        int result = e2.getValue().compareTo(e1.getValue());
                        if (result == 0) {
                            result = e1.getKey().compareTo(e2.getKey());
                        }
                        return result;
                    }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> {throw new AssertionError();}, LinkedHashMap::new));

            sortedEntry.entrySet().stream().forEach(e-> System.out.printf("-> %s : %d%n",e.getKey(),e.getValue()));
        }
    }

}
