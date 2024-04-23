package com.pluralsight;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Create the variables.
    static int numPlayers;
    static List<Player> players;
    static String playerName;
    static Deck deck;
    static String choice;
    static Card card;
    static Player winner;
    static int highestScore;
    static int score;

    public static void main(String[] args) {
        // Print main menu.
        System.out.println("Welcome to Blackjack!");
        System.out.print("Enter the number of players: ");
        numPlayers = scanner.nextInt();
        scanner.nextLine();

        // Initalize the array.
        players = new ArrayList<>();
        
        // Ask user for their name.
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            playerName = scanner.nextLine();

            // Add them to the game.
            players.add(new Player(playerName));
        }

        // Initalize the deck.
        deck = new Deck();

        // Deal inital cards to player then display their hand.
        for (Player player : players) {
            dealInitialCards(deck, player);
            player.displayHand();
        }

        // Ask user if they want to hit.
        for (Player player : players) {
            while (true) {
                System.out.print(player.name + ", do you want to hit? (yes/no): ");
                choice = scanner.nextLine().toLowerCase();

                // If user hit and now has greater than 21, he busts
                if ("yes".equals(choice)) {
                    card = deck.dealCard();
                    player.addCardToHand(card);
                    player.displayHand();

                    if (player.calculateScore() > 21) {
                        System.out.println(player.name + " busts!");
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        // Determine the winner.
        winner = determineWinner(players);

        // Print winner.
        if (winner != null) {
            System.out.println("The winner is: " + winner.name);
        // Print if its a tie.
        } else {
            System.out.println("It's a tie!");
        }
    }

    // Create dealInitialCards method.
    private static void dealInitialCards(Deck deck, Player player) {
        // Give player 2 cards.
        for (int i = 0; i < 2; i++) {
            card = deck.dealCard();
            player.addCardToHand(card);
        }
    }

    // Create determineWinner method.
    private static Player determineWinner(List<Player> players) {
        // Initialize the variables.
        winner = null;
        highestScore = 0;

        // Determine the winner.
        for (Player player : players) {
            int score = player.calculateScore();
            if (score <= 21 && score > highestScore) {
                highestScore = score;
                winner = player;
            }
        }

        return winner;
    }
}