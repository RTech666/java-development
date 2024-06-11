package com.pluralsight;

public class SalesByCategory {
    // Create variables, as private.
    private String productName;
    private double totalPurchase;

    // Create the constructor.
    public SalesByCategory(String productName, double totalPurchase) {
        this.productName = productName;
        this.totalPurchase = totalPurchase;
    }

    // Create getters and setters.
    public String getProductName() {
        return productName;
    }

    public double getTotalPurchase() {
        return totalPurchase;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTotalPurchase(double totalPurchase) {
        this.totalPurchase = totalPurchase;
    }
}