package com.pluralsight;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;
import org.apache.commons.dbcp2.BasicDataSource;

public class Main {
    // Create database connection.
    private static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/sakila");
        ds.setUsername("root");
        ds.setPassword("TC2%T@ajrGUhcB");
        return ds;
    }

    public static void main(String[] args) {
        DataSource dataSource = getDataSource();
        Scanner scanner = new Scanner(System.in);

        try (Connection connection = dataSource.getConnection()) {
            // Ask user for the last name.
            System.out.print("Enter the last name of an actor you like: ");
            String lastName = scanner.nextLine();

            // Find actors with entered last name.
            String actorQuery = "SELECT first_name, last_name FROM actor WHERE last_name = ?";
            try (PreparedStatement actorStatement = connection.prepareStatement(actorQuery)) {
                actorStatement.setString(1, lastName);
                try (ResultSet actorResults = actorStatement.executeQuery()) {
                    if (actorResults.next()) {
                        System.out.println("Your matches are:");
                        do {
                            System.out.println(actorResults.getString("first_name") + " " + actorResults.getString("last_name"));
                        } while (actorResults.next());
                    } else {
                        System.out.println("No matches!");
                    }
                }
            }

            // Ask user for the first name and last name of an actor
            System.out.print("Enter the first name of the actor you want to see the movies of: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter the last name of the actor you want to see the movies of: ");
            String fullLastName = scanner.nextLine();

            // Find the actor's ID
            String actorIdQuery = "SELECT actor_id FROM actor WHERE first_name = ? AND last_name = ?";
            int actorId = -1;
            try (PreparedStatement actorIdStatement = connection.prepareStatement(actorIdQuery)) {
                actorIdStatement.setString(1, firstName);
                actorIdStatement.setString(2, fullLastName);
                try (ResultSet actorIdResults = actorIdStatement.executeQuery()) {
                    if (actorIdResults.next()) {
                        actorId = actorIdResults.getInt("actor_id");
                    } else {
                        System.out.println("No actor found with the name " + firstName + " " + fullLastName);
                    }
                }
            }

            if (actorId != -1) {
                // Find movie titles for that actor using actor ID
                String movieQuery = "SELECT f.title FROM film f " + "JOIN film_actor fa ON f.film_id = fa.film_id " + "WHERE fa.actor_id = ?";
                try (PreparedStatement movieStatement = connection.prepareStatement(movieQuery)) {
                    movieStatement.setInt(1, actorId);
                    try (ResultSet movieResults = movieStatement.executeQuery()) {
                        if (movieResults.next()) {
                            System.out.println("Movies of " + firstName + " " + fullLastName + ":");
                            do {
                                System.out.println(movieResults.getString("title"));
                            } while (movieResults.next());
                        } else {
                            System.out.println("No movies found for " + firstName + " " + fullLastName);
                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}