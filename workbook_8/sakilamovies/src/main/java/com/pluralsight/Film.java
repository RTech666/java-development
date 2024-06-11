package com.pluralsight;

public class Film {
    // Create the variables, as private.
    private int filmID;
    private String title;
    private String description;
    private int releaseYear;
    private int length;

    // Create the constructor.
    public Film(int filmID, String title, String description, int releaseYear, int length) {
        this.filmID = filmID;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.length = length;
    }

    // Create getters.
    public int getFilmID() {
        return filmID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getLength() {
        return length;
    }

    // Create override string.
    @Override
    public String toString() {
        return title + " (" + releaseYear + ") - " + length + " min";
    }
}