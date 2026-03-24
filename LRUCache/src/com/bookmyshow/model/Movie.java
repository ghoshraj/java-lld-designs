package com.bookmyshow.model;

public class Movie {

    private String movieId;
    private String name;
    private int duration; // in minutes

    public Movie(String movieId, String name, int duration) {
        this.movieId = movieId;
        this.name = name;
        this.duration = duration;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}