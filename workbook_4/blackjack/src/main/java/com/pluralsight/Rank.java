package com.pluralsight;

// Create constant Rank..
public enum Rank {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

    // Create the variable, as private.
    private int value;

    // Create the constrcutor.
    Rank(int value) {
        this.value = value;
    }

    // Create the getter.
    public int getValue() {
        return value;
    }
}