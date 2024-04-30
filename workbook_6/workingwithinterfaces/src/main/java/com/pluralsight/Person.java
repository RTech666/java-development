package com.pluralsight;

class Person implements Comparable<Person> {
    // Create the variables, as private.
    private String firstName;
    private String lastName;
    private int age;

    // Create the constructor.
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Create getters.
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    // Create override compareTo method.
    @Override
    public int compareTo(Person otherPerson) {
        // Compare by last name.
        int lastNameComparison = this.lastName.compareTo(otherPerson.getLastName());
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        // If last names are the same, compare by first name.
        int firstNameComparison = this.firstName.compareTo(otherPerson.getFirstName());
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        // If first and last name is the same, compare by age.
        return Integer.compare(this.age, otherPerson.getAge());
    }

    // Create override toString method.
    @Override
    public String toString() {
        return firstName + " " + lastName + " (Age: " + age + ")";
    }
}