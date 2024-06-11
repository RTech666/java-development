package com.pluralsight;

public class CustomerOrderHistory {
    // Create variables, as private.
    private String productName;
    private int total;

    // Create the constructor.
    public CustomerOrderHistory(String productName, int total) {
        this.productName = productName;
        this.total = total;
    }

    // Create getters and setters.
    public String getProductName() {
        return productName;
    }

    public int getTotal() {
        return total;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}