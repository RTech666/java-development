package workbook_4.com.pluralsight;

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
}
