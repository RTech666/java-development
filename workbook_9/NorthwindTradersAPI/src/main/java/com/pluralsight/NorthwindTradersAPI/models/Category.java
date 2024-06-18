package com.pluralsight.NorthwindTradersAPI.models;

public class Category {
    // Create variables, as private.
    private int categoryId;
    private String categoryName;

    // Create the contructor.
    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    // Create getters and setters.
    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}