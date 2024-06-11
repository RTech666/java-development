package com.pluralsight;
import javax.sql.DataSource;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.dbcp2.BasicDataSource;

public class Main {
    // Create the database connection.
    private static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/sakila");
        ds.setUsername("root");
        ds.setPassword("TC2%T@ajrGUhcB");
        return ds;
    }

    public static void main(String[] args) {
        DataSource dataSource = getDataSource();
        DataManager dataManager = new DataManager(dataSource);
        Scanner scanner = new Scanner(System.in);

        // Ask user for the last name of an actor.
        System.out.print("Enter the last name of an actor you like: ");
        String lastName = scanner.nextLine();
        List<Actor> actors = dataManager.findActorsByLastName(lastName);

        if (actors.isEmpty()) {
            System.out.println("No matches!");
        } else {
            System.out.println("Your matches are:");
            for (Actor actor : actors) {
                System.out.println(actor);
            }

            // Ask user for the actor ID to get their movies.
            System.out.print("Enter the actor ID to see their movies: ");
            int actorID = scanner.nextInt();
            List<Film> films = dataManager.findFilmsByActorID(actorID);

            if (films.isEmpty()) {
                System.out.println("No movies found for actor ID " + actorID);
            } else {
                System.out.println("Movies:");
                for (Film film : films) {
                    System.out.println(film);
                }
            }
        }
    }
}