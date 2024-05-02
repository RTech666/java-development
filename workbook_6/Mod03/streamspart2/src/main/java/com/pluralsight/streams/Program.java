package com.pluralsight.streams;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    // Initalize the scanner.
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create the variable.
        List<Person> people = createPeopleList();

        // Ask user for a name to search for.
        System.out.print("Enter a name to search: ");
        String searchName = scanner.nextLine();

        // Create stream and filter function.
        List<Person> matchingPeople = people.stream().filter(person -> person.getFirstName().equalsIgnoreCase(searchName) || person.getLastName().equalsIgnoreCase(searchName)).collect(Collectors.toList());

        // Print the results.
        System.out.println("People with name '" + searchName + "':");
        matchingPeople.forEach(person -> System.out.println(person.getFirstName() + " " + person.getLastName()));

        // Get average age, then print.
        double averageAge = people.stream().mapToDouble(Person::getAge).average().orElse(0);
        System.out.println("Average age of all people: " + averageAge);

        // Get oldest age, then print.
        int oldestAge = people.stream().mapToInt(Person::getAge).max().orElse(0);
        System.out.println("Age of the oldest person: " + oldestAge);

        // Get youngest age, then print.
        int youngestAge = people.stream().mapToInt(Person::getAge).min().orElse(0);
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
}