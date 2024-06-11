package com.pluralsight;

public class Actor {
    // Create variables, as private.
    private int actorID;
    private String firstName;
    private String lastName;

    // Create the constructor.
    public Actor(int actorID, String firstName, String lastName) {
        this.actorID = actorID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Create getters.
    public int getActorID() {
        return actorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Create override string.
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}