package com.EnumerationsAndAnnotations.Card;

import java.util.TreeSet;

public class Player implements Comparable<Player> {
    private String name;
    private TreeSet<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand= new TreeSet<>();
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public String getName() {
        return name;
    }

    public TreeSet<Card> getHand() {
        return hand;
    }


    @Override
    public int compareTo(Player other) {
        Card bestCard = this.hand.last();
        Card otherBestCard = other.hand.last();

        return bestCard.compareTo(otherBestCard);
    }
}
