package com.pluralsight;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initalize the scanner.
        Scanner scanner = new Scanner(System.in);

        // Ask user for their name.
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Print greeting.
        System.out.println("Hello " + name + "!");
    }
}