package services;

import java.util.*;

import model.*;

public class Watchlist {
    private List<Movie> moviesList = new ArrayList<>();

    public void addMovie(Movie movie) {
        this.moviesList.add(movie);
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public void setMovies(List<Movie> movies) {
        this.moviesList = movies;
    }

    public boolean removeMovie(Movie movie) {
        return this.moviesList.remove(movie);
    }

    public List<Movie> searchMoviesByTitle(String title) {
        List<Movie> results = new ArrayList<>();

        for (Movie movie : moviesList) {
            if (movie.getTitle().equals(title)) {
                results.add(movie);
            }
        }

        return results;
    }

    public List<Movie> searchMoviesByDirector(String director) {
        List<Movie> results = new ArrayList<>();

        for (Movie movie : moviesList) {
            if (movie.getDirector().equals(director)) {
                results.add(movie);
            }
        }

        return results;
    }
}
