package workbook_4.com.pluralsight;

public class Hotel {
    // Create the variables, as private.
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // Create the constrcutor without booked rooms.
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this(name, numberOfSuites, numberOfRooms, 0, 0);
    }

    // Create the constrcutor with booked rooms.
    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // Create bookRoom method.
    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            // If their is available suite rooms, update it.
            if (numberOfRooms <= getAvailableSuites()) {
                bookedSuites += numberOfRooms;

                // Return true if can be booked.
                return true;
            }
        } else {
            // If their is available basic rooms, update it.
            if (numberOfRooms <= getAvailableRooms()) {
                bookedBasicRooms += numberOfRooms;

                // Return true if can be booked.
                return true;
            }
        }
        return false;
    }

    // Create derived getters.
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }
}