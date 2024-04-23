package com.pluralsight;
import java.util.ArrayList;
import java.util.List;

public class Player {
    // Create the variables.
    String name;
    private List<Card> hand;
    private int score;
    private int numberOfAces;

    // Create the constrcutor.
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    // Create addCardToHand method.
    public void addCardToHand(Card card) {
        hand.add(card);
    }

    // Create calculateScore method.
    public int calculateScore() {
        // Initalize the variables.
        score = 0;
        numberOfAces = 0;

        for (Card card : hand) {
            score += card.getValue();
            if (card.getValue() == 11) {
                numberOfAces++;
            }
        }

        while (score > 21 && numberOfAces > 0) {
            score -= 10;
            numberOfAces--;
        }

        return score;
    }

    // Create displayHand method.
    public void displayHand() {
        // Print out user's hand and total score.
        System.out.println(name + "'s hand:");

        for (Card card : hand) {
            System.out.println(" - " + card);
        }

        System.out.println("Total Score: " + calculateScore());
    }
}