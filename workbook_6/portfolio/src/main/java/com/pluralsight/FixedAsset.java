package com.pluralsight;

abstract class FixedAsset implements Valuable {
    // Create the variables, as private.
    private String name;
    private double marketValue;

    // Create the constructor.
    public FixedAsset(String name, double value) {
        this.name = name;
        this.marketValue = value;
    }

    // Create the override getValue method.
    @Override
    public double getValue() {
        return marketValue;
    }
}