package com.EnumerationsAndAnnotations.CardRanks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        System.out.println(String.format("%s:",input));
        for (CardRank rank : CardRank.values()) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", rank.ordinal(), rank.name()));
        }
    }
}
