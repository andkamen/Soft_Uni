package com.EnumerationsAndAnnotations.CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CardRank rank = Enum.valueOf(CardRank.class,reader.readLine());
        CardSuit suit = Enum.valueOf(CardSuit.class,reader.readLine());

        System.out.printf("Card name: %s of %s; Card power: %d",rank.name(),suit.name(),rank.getPower()+suit.getPower());
    }
}
