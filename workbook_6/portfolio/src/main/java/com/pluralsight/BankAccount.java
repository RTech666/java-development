package com.pluralsight;

public class BankAccount implements Valuable {
    // Create the variables, as private.
    private String name;
    private int accountNumber;
    private double balance;

    // Create the constructor.
    public BankAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // Create the deposit method.
    public void deposit(double amount) {
        balance += amount;
    }

    // Create the withdraw method.
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // Create the override getValue method.
    @Override
    public double getValue() {
        return balance;
    }
}