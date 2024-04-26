package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        // Create each vehicle type.
        Moped moped = new Moped();
        Car car = new Car();
        SemiTruck semitruck = new SemiTruck();
        Hovercraft hovercraft = new Hovercraft();

        // Set values for the moped.
        moped.setColor("Red");
        moped.setFuelCapacity(5);

        // Set values for the car.
        car.setColor("Blue");
        car.setNumberOfPassengers(5);
        car.setFuelCapacity(50);

        // Set values for the semitruck.
        semitruck.setColor("White");
        semitruck.setCargoCapacity(1000);
        semitruck.setFuelCapacity(200);

        // Set values for the hovercraft.
        hovercraft.setColor("Yellow");
        hovercraft.setNumberOfPassengers(20);
        hovercraft.setCargoCapacity(500);
        hovercraft.setFuelCapacity(1000);

        // Print out the information.
        System.out.println("Moped color: " + moped.getColor());
        System.out.println("Moped fuel capacity: " + moped.getFuelCapacity());

        System.out.println("Car color: " + car.getColor());
        System.out.println("Car fuel capacity: " + car.getFuelCapacity());

        System.out.println("Semi-truck color: " + semitruck.getColor());
        System.out.println("Semi-truck cargo capacity: " + semitruck.getCargoCapacity());

        System.out.println("Hovercraft color: " + hovercraft.getColor());
        System.out.println("Hovercraft passengers: " + hovercraft.getNumberOfPassengers());
    }
}