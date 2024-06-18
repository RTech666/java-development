package com.pluralsight.NorthwindTradersAPI.models;

public class Product {
    // Create variables, as private.
    private int productId;
    private String productName;
    private int categoryId;
    private double unitPrice;

    // Create the contructor.
    public Product(int productId, String productName, int categoryId, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
    }

    // Create getters and setters.
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
