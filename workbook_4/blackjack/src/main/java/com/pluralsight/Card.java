package com.pluralsight;

public class Card {
    // Create the variables, as private.
    private Suit suit;
    private Rank rank;

    // Create the constrcutor.
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Create the getter.
    public int getValue() {
        return rank.getValue();
    }

    // Create the override toString.
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}