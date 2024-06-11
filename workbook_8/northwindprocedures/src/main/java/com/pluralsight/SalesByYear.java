package com.pluralsight;
import java.util.Date;

public class SalesByYear {
    // Create variables, as private.
    private Date shippedDate;
    private int orderID;
    private double subtotal;

    // Create the constructor.
    public SalesByYear(Date shippedDate, int orderID, double subtotal) {
        this.shippedDate = shippedDate;
        this.orderID = orderID;
        this.subtotal = subtotal;
    }

    // Create getters and setters.
    public Date getShippedDate() {
        return shippedDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}