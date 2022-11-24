package com.javabrains.moviecatalogservice.models;

public class Movie {

    private String name;
    private String movieId;

    public Movie(){

    }
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

}
