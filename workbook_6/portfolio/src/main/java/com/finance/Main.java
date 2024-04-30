package com.finance;
import com.pluralsight.*;
import java.util.Scanner;

public class Main {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    // Initalize the portfolio.
    static Portfolio portfolio = new Portfolio("Portfolio", "John Doe");
    
    public static void main(String[] args) {
        while (true) {
            // Print main menu.
            System.out.println("\nSelect asset type to add:");
            System.out.println("1. Bank Account");
            System.out.println("2. Credit Card");
            System.out.println("3. Gold");
            System.out.println("4. Jewelry");
            System.out.println("5. House");
            System.out.println("6. Portfolio Information");
            System.out.println("7. Exit");

            // Ask user for their choice.
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Read the user input and execute the appropiate method.
            switch (choice) {
                case 1:
                    bankAccount();
                    break;
                case 2:
                    creditCard();
                    break;
                case 3:
                    gold();
                    break;
                case 4:
                    jewelry();
                    break;
                case 5:
                    house();
                    break;
                case 6:
                    portfolioInformation();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }

    // Create bankAccount method.
    public static void bankAccount() {
        // Ask user for the account name:
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();

        // Ask user for the account number.
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        // Ask user for the account balance.
        System.out.print("Enter account balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        // Add the bank account to the portfolio.
        portfolio.add(new BankAccount(accountNumber, accountName, balance));
    }

    // Create creditCard method.
    public static void creditCard() {
        // Ask user for the credit card name.
        System.out.print("Enter credit card name: ");
        String cardName = scanner.nextLine();

        // Ask user for the card number.
        System.out.print("Enter card number: ");
        String cardNumber = scanner.nextLine();

        // Ask user for the card balance.
        System.out.print("Enter card balance: ");
        double cardBalance = scanner.nextDouble();
        scanner.nextLine();

        // Add the credit card to the portfolio.
        portfolio.add(new CreditCard(cardName, cardNumber, cardBalance));
    }

    // Create gold method.
    public static void gold() {
        // Ask user for the weight of their gold.
        System.out.print("Enter weight of gold: ");
        double goldWeight = scanner.nextDouble();

        // Add the gold to the portfolio.
        portfolio.add(new Gold(goldWeight));
    }

    // Create jewelry method.
    public static void jewelry() {
        // Ask user for the name of the jewelry.
        System.out.print("Enter name of jewelry: ");
        String jewelryName = scanner.nextLine();

        // Ask user for the karat of the jewelry.
        System.out.print("Enter karat of jewelry: ");
        double karat = scanner.nextDouble();

        // Add the jewelry to the portfolio.
        portfolio.add(new Jewelry(jewelryName, karat));
    }

    // Create house method.
    public static void house() {
        // Ask the user for the year the house was built.
        System.out.print("Enter year built: ");
        int yearBuilt = scanner.nextInt();

        // Ask the user for the square feet.
        System.out.print("Enter square feet: ");
        int squareFeet = scanner.nextInt();

        // Ask the user for the number of bedrooms.
        System.out.print("Enter number of bedrooms: ");
        int bedrooms = scanner.nextInt();

        // Add the house to the portfolio.
        portfolio.add(new House(yearBuilt, squareFeet, bedrooms));
    }

    // Create portfolioInformation method.
    public static void portfolioInformation() {
        // Print portfolio total value.
        System.out.println("Portfolio total value: $" + portfolio.getValue());

        // Print most valuable asset from the portfolio.
        Valuable mostValuable = portfolio.getMostValuable();
        if (mostValuable != null) {
            System.out.println("Most valuable asset: " + mostValuable.getClass().getSimpleName() + " - $" + mostValuable.getValue());
        } else {
            System.out.println("No assets in the portfolio.");
        }

        // Print least valuable asset from the portfolio.
        Valuable leastValuable = portfolio.getLeastValuable();
        if (leastValuable != null) {
            System.out.println("Least valuable asset: " + leastValuable.getClass().getSimpleName() + " - $" + leastValuable.getValue());
        } else {
            System.out.println("No assets in the portfolio.");
        }
    }
}