package com.pluralsight;

public class Jewelry extends FixedAsset {
    // Create the variables, as private.
    private double karat;

    // Create the constructor.
    public Jewelry(String name, double karat) {
        // Set the value.
        super(name, 0);
        this.karat = karat;
    }

    // Create the override getValue method.
    @Override
    public double getValue() {
        // Calculate the total value.
        return super.getValue() * karat;
    }
}