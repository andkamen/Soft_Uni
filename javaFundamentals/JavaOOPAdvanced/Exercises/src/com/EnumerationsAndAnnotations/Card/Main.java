package com.EnumerationsAndAnnotations.Card;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        //Problem 5.	Card compareTo()
//        CardRank rank = Enum.valueOf(CardRank.class, reader.readLine());
//        CardSuit suit = Enum.valueOf(CardSuit.class, reader.readLine());
//
//        Card card1 = new Card(rank, suit);
//
//        rank = Enum.valueOf(CardRank.class, reader.readLine());
//        suit = Enum.valueOf(CardSuit.class, reader.readLine());
//
//        Card card2 = new Card(rank, suit);
//
//        //System.out.println(card1.compareTo(card2) > 0 ? card1 : card2);
//
//        if (card1.compareTo(card2) > 0) {
//            System.out.println(card1);
//        } else {
//            System.out.println(card2);
//        }

//        //Problem 6.	Custom Enum Annotation
//        String type = reader.readLine();
//        Class<CardRank> rankClass = CardRank.class;
//        Class<CardSuit> suitsClass = CardSuit.class;
//
//        CardInfo rankInfo = rankClass.getAnnotation(CardInfo.class);
//        CardInfo suitInfo = suitsClass.getAnnotation(CardInfo.class);
//
//
//        switch (type){
//            case "Rank":
//                System.out.printf("Type = %s, Description = %s%n", rankInfo.type(), rankInfo.description());
//                break;
//
//            case "Suit":
//                System.out.printf("Type = %s, Description = %s%n", suitInfo.type(), suitInfo.description());
//                break;
//        }

//        //Problem 7.	Deck of Cards
//        for (CardSuit suit : CardSuit.values()) {
//            for (CardRank rank : CardRank.values()) {
//                System.out.println(String.format("%s of %s", rank, suit));
//            }
//        }

        Player firstPlayer = new Player(reader.readLine());
        Player secondPlayer = new Player(reader.readLine());

        TreeSet<Card> hands = new TreeSet<>();

        ReadHand(reader, hands, firstPlayer);
        ReadHand(reader, hands, secondPlayer);


        if (firstPlayer.compareTo(secondPlayer) > 0) {
            System.out.printf("%s wins with %s of %s.", firstPlayer.getName(),
                    firstPlayer.getHand().last().getRank(),
                    firstPlayer.getHand().last().getSuit());
        } else {
            System.out.printf("%s wins with %s of %s.", secondPlayer.getName(),
                    secondPlayer.getHand().last().getRank(),
                    secondPlayer.getHand().last().getSuit());
        }
    }

    private static void ReadHand(BufferedReader reader, TreeSet<Card> hands, Player player) throws IOException {
        while (player.getHand().size() != 5) {
            String[] params = reader.readLine().split("\\s+");
            CardRank rank;
            CardSuit suit;
            try {
                rank = Enum.valueOf(CardRank.class, params[0]);
                suit = Enum.valueOf(CardSuit.class, params[2]);
            } catch (IllegalArgumentException iae) {
                System.out.println("No such card exists.");
                continue;
            }

            Card card = new Card(rank, suit);

            if (!hands.contains(card)) {
                player.addCard(card);
                hands.add(card);
            } else {
                System.out.println("Card is not in the deck.");
            }
        }
    }
}
