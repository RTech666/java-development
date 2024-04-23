package workbook_4.com.pluralsight;

public class Reservation {
    // Create the variables, as private.
    private String roomType;
    private double pricePerNight;
    private int numberOfNights;
    private boolean isWeekend;

    // Create the constrcutor.
    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        // Set roomType to lowercase.
        this.roomType = roomType.toLowerCase();
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;

        // Set price if king.
        if (this.roomType.equals("king")) {
            this.pricePerNight = 139.00;
        // Set price if double.
        } else if (this.roomType.equals("double")) {
            this.pricePerNight = 124.00;
        } else {
            // Print message if not king or double.
            System.out.println("Invalid room type.");
        }

        // Increase price per night by 10% for weekend stay.
        if (isWeekend) {
            this.pricePerNight *= 1.10;
        }
    }

    // Create the getters and setters.
    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public double getReservationTotal() {
        return pricePerNight * numberOfNights;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType.toLowerCase();
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }
}
