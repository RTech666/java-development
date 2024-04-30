package com.finance;
import com.pluralsight.BankAccount;
import com.pluralsight.Valuable;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(123, "Pam", 12500);
        Valueable account2 = new BankAccount(456, "Gary", 1500);

        // Try to deposit money into both accounts.
        account1.deposit(100);
        account2.deposit(100);
    }
}