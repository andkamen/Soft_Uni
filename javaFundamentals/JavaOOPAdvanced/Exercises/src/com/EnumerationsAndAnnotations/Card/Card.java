package com.EnumerationsAndAnnotations.Card;

public class Card implements Comparable<Card> {

    private CardRank rank;
    private CardSuit suit;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.rank.name(), this.suit.name(), this.rank.getPower() + this.suit.getPower());
    }

    @Override
    public int compareTo(Card other) {
        int CardPower = this.rank.getPower() + this.suit.getPower();
        int otherCardPower = other.rank.getPower() + other.suit.getPower();

        return Integer.compare(CardPower, otherCardPower);
    }
}
