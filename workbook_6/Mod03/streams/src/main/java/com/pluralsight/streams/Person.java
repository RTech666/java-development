package com.pluralsight.streams;

class Person {
    // Initalize the variables, as private.
    private String firstName;
    private String lastName;
    private int age;

    // Create the constructor.
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Create the getters.
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}