package com._02_SetsAndMaps;

import javafx.scene.Node;

import java.util.*;

public class _08_HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Set<String>> playerScores = new LinkedHashMap<>();

        HashMap<String, Integer> cardValues = new HashMap<>();
        cardValues.put("J", 11);
        cardValues.put("Q", 12);
        cardValues.put("K", 13);
        cardValues.put("A", 14);
        cardValues.put("2", 2);
        cardValues.put("3", 3);
        cardValues.put("4", 4);
        cardValues.put("5", 5);
        cardValues.put("6", 6);
        cardValues.put("7", 7);
        cardValues.put("8", 8);
        cardValues.put("9", 9);
        cardValues.put("10", 10);
        cardValues.put("C", 1);
        cardValues.put("D", 2);
        cardValues.put("H", 3);
        cardValues.put("S", 4);

        String[] inputData = scan.nextLine().trim().split(": ");

        while (!inputData[0].equals("JOKER")) {
            String[] playerHand = inputData[1].split(", ");

            if (!playerScores.containsKey(inputData[0])) {
                playerScores.put(inputData[0], new HashSet<>());
            }
            for (String card : playerHand) {
                playerScores.get(inputData[0]).add(card);
            }

            inputData = scan.nextLine().trim().split(": ");
        }

        for (Map.Entry<String, Set<String>> entry : playerScores.entrySet()) {
            int totalScore = 0;
            int score = 0;
            int multiplier = 0;
            for (String s : entry.getValue()) {
                char index = s.charAt(s.length() - 1);
                multiplier = cardValues.get(String.format("%c",index));
                String substr = s.substring(0,s.length()-1);
                score = cardValues.get(substr);
                totalScore += score*multiplier;
            }

            System.out.printf("%s: %d%n",entry.getKey(),totalScore);
        }
    }
}
