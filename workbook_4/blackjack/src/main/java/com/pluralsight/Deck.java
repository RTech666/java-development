package com.pluralsight;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    // Create the variable.
    private List<Card> cards;

    public Deck() {
        // Initalize the array.
        cards = new ArrayList<>();

        // Add cards.
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }

        // Shuffle cards.
        shuffle();
    }

    // Create shuffle method.
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Create dealCard method.
    public Card dealCard() {
        // Print error if no more cards in the deck.
        if (cards.isEmpty()) {
            throw new IllegalStateException("No cards left in the deck");
        }

        return cards.remove(cards.size() - 1);
    }
}

