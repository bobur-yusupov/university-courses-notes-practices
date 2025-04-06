import model.Movie;
import model.Genre;
import model.Status;
import services.Watchlist;
import util.FileManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Watchlist watchlist = new Watchlist();

        // Load existing movies from file
        List<Movie> loadedMovies = FileManager.loadMovies();
        watchlist.setMovies(loadedMovies);

        // Add test movies
        watchlist.addMovie(new Movie(1, "Inception", "Christopher Nolan", Genre.SCIFI, Status.TO_WATCH));
        watchlist.addMovie(new Movie(2, "The Dark Knight", "Christopher Nolan", Genre.ACTION, Status.WATCHED));
        watchlist.addMovie(new Movie(3, "Oppenheimer", "Christopher Nolan", Genre.DRAMA, Status.TO_WATCH));
        watchlist.addMovie(new Movie(4, "Interstellar", "Christopher Nolan", Genre.SCIFI, Status.WATCHED));

        // Save to file
        FileManager.saveToFile(watchlist.getMoviesList());

        // Search
        List<Movie> searchResults = watchlist.searchMoviesByTitle("dark");
        System.out.println("Search results for 'dark':");
        for (Movie m : searchResults) {
            System.out.println(m);
        }

        // List all movies
        System.out.println("\nAll Movies in Watchlist:");
        for (Movie m : watchlist.getMoviesList()) {
            System.out.println(m);
        }
    }
}
