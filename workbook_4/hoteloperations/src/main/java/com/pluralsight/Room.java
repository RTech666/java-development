package com.pluralsight;

public class Room {
    // Create the variables, as private.
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    // Create the constrcutor.
    public Room(int numberOfBeds, double price) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = false;
        this.dirty = false;
    }

    // Create the getters and setters.
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    // Create checkIn method.
    public void checkIn() {
        if (!occupied) {
            // Set to occupied and dirty, then print message.
            occupied = true;
            dirty = true;
            System.out.println("Room checked in. Room is now occupied and marked as dirty.");
        // If room is occupied, print message.
        } else {
            System.out.println("Cannot check in. Room is already occupied.");
        }
    }

    // Create checkOut method.
    public void checkOut() {
        if (occupied) {
            // Call cleanRoom method.
            cleanRoom();

            // Set to not occupied.
            occupied = false;
            System.out.println("Guest checked out. Room is now available for check-in.");
        // If room is not occupied, print message.
        } else {
            System.out.println("Cannot check out. Room is not occupied.");
        }
    }

    // Create cleanRoom method.
    public void cleanRoom() {
        if (dirty) {
            // Set to not dirty, then print message.
            dirty = false;
            System.out.println("Room cleaned successfully.");
        // If room is not dirty, print message.
        } else {
            System.out.println("Room is already clean.");
        }
    }
}