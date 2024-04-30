package com.pluralsight;

class House extends FixedAsset {
    // Create the variables, as private.
    private int yearBuilt;
    private int squareFeet;
    private int bedrooms;

    // Create the constructor.
    public House(int year, int squareFeet, int bedrooms) {
        // Set the value.
        super("House", 0);
        this.yearBuilt = year;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
    }

    // Create the override getValue method.
    @Override
    public double getValue() {
        // Calculate the total value.
        return super.getValue() + (yearBuilt * squareFeet * bedrooms);
    }
}