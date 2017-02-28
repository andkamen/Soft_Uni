package com._02_SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class _12_LegendaryFarming {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> junk = new TreeMap<>();
        HashMap<String, Integer> materials = new HashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        boolean shouldContinue = true;
        String winningMaterial = "";

        while (true) {
            if (!shouldContinue) {
                break;
            }

            String[] input = reader.readLine().toLowerCase().split("\\s+");
            if (input.length < 2) {
                shouldContinue = false;
                continue;
            }
            for (int i = 0; i < input.length; i += 2) {
                String material = input[i + 1];
                int amount = Integer.parseInt(input[i]);
                if (materials.containsKey(material)) {
                    int val = materials.get(material) + amount;
                    materials.put(material, val);
                    if (val >= 250) {
                        materials.put(material, val - 250);
                        winningMaterial = material;
                        shouldContinue = false;
                        break;
                    }
                } else {
                    if (!junk.containsKey(material)) {
                        junk.put(material, amount);
                    } else {
                        junk.put(material, junk.get(material) + amount);
                    }
                }
            }
        }

        switch (winningMaterial) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }
        LinkedHashMap<String, Integer> orderedMaterials = new LinkedHashMap<>();
        materials.entrySet().stream().sorted((m1,m2)->{
            int result = m2.getValue().compareTo(m1.getValue());
            if (result==0){
                result = m1.getKey().compareTo(m2.getKey());
            }
            return result;
        }).forEach(m->orderedMaterials.put(m.getKey(),m.getValue()));

        for (Map.Entry<String, Integer> entry : orderedMaterials.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }

    }
}
