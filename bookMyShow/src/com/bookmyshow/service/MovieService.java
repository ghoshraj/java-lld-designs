package com.bookmyshow.service;

import com.bookmyshow.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private List<Movie> movieList = new ArrayList<>();

    public MovieService(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Movie> getAllMovies() {
        return movieList;
    }
}
