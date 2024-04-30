package com.pluralsight.streams;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create the variable.
        List<Person> people = createPeopleList();

        // Ask user for a name to search for.
        System.out.print("Enter a name to search: ");
        String searchName = scanner.nextLine();

        // Initalize the array.
        List<Person> matchingPeople = new ArrayList<>();

        // Create a list of people that matched the search.
        for (Person person : people) {
            if (person.getFirstName().equalsIgnoreCase(searchName) || person.getLastName().equalsIgnoreCase(searchName)) {
                matchingPeople.add(person);
            }
        }

        // Print the results.
        System.out.println("People with name '" + searchName + "':");
        for (Person person : matchingPeople) {
            System.out.println(person.getFirstName() + " " + person.getLastName());
        }

        // Get average age, then print.
        double averageAge = calculateAverage(people);
        System.out.println("Average age of all people: " + averageAge);

        // Get oldest age, then print.
        int oldestAge = getOldest(people);
        System.out.println("Age of the oldest person: " + oldestAge);

        // Get youngest age, then print.
        int youngestAge = getYoungest(people);
        System.out.println("Age of the youngest person: " + youngestAge);
    }

    // Create the createPeopleList method.
    private static List<Person> createPeopleList() {
        // Initalize the list.
        List<Person> people = new ArrayList<>();

        // Add 10 people.
        people.add(new Person("John", "Doe", 25));
        people.add(new Person("Jane", "Smith", 30));
        people.add(new Person("Alice", "Johnson", 22));
        people.add(new Person("Bob", "Williams", 35));
        people.add(new Person("Emily", "Brown", 28));
        people.add(new Person("Michael", "Jones", 40));
        people.add(new Person("Emma", "Davis", 32));
        people.add(new Person("David", "Miller", 27));
        people.add(new Person("Olivia", "Wilson", 29));
        people.add(new Person("William", "Taylor", 33));

        return people;
    }

    // Create calculateAverage method.
    private static double calculateAverage(List<Person> people) {
        // Initalize the variable.
        int totalAge = 0;

        // Add all the ages.
        for (Person person : people) {
            totalAge += person.getAge();
        }

        // Calculate the average then print.
        return (double) totalAge / people.size();
    }

    // Create getOldest method.
    private static int getOldest(List<Person> people) {
        // Initalize the variable.
        int maxAge = Integer.MIN_VALUE;

        // Find oldest age.
        for (Person person : people) {
            maxAge = Math.max(maxAge, person.getAge());
        }

        // Print.
        return maxAge;
    }

    // Create getYoungest method.
    private static int getYoungest(List<Person> people) {
        // Initalize the variable.
        int minAge = Integer.MAX_VALUE;

        // Find youngest age.
        for (Person person : people) {
            minAge = Math.min(minAge, person.getAge());
        }

        // Print.
        return minAge;
    }
}