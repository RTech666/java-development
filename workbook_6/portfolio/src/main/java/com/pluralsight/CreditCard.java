package com.pluralsight;

class CreditCard implements Valuable {
    // Create the variables, as private.
    private String name;
    private String accountNumber;
    private double balance;

    // Create the constructor.
    public CreditCard(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Create the charge method.
    public void charge(double amount) {
        balance += amount;
    }

    // Create the pay method.
    public void pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance to pay.");
        }
    }
    
    // Create the override getValue method.
    @Override
    public double getValue() {
        // Set to negative since they have to pay the balance.
        return balance * -1;
    }
}