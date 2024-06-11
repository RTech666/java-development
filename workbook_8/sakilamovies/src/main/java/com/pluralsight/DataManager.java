package com.pluralsight;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Create findActorsByLastName method.
    public List<Actor> findActorsByLastName(String lastName) {
        List<Actor> actors = new ArrayList<>();
        String query = "SELECT actor_id, first_name, last_name FROM actor WHERE last_name = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, lastName);
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    actors.add(new Actor(
                            results.getInt("actor_id"),
                            results.getString("first_name"),
                            results.getString("last_name")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    // Create findFilmsByActorID method.
    public List<Film> findFilmsByActorID(int actorId) {
        List<Film> films = new ArrayList<>();
        String query = "SELECT f.film_id, f.title, f.description, f.release_year, f.length " + "FROM film f JOIN film_actor fa ON f.film_id = fa.film_id " + "WHERE fa.actor_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, actorId);
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    films.add(new Film(
                            results.getInt("film_id"),
                            results.getString("title"),
                            results.getString("description"),
                            results.getInt("release_year"),
                            results.getInt("length")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }
}