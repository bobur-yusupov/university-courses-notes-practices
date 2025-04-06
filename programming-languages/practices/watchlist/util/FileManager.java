package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Genre;
import model.Movie;
import model.Status;

public class FileManager {
    private static final String FILE_NAME = "watchlist.txt";

    public static List<Movie> loadMovies() {
        List<Movie> moviesList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                if (parts.length != 5) continue;

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String director = parts[2];
                Status status = Status.valueOf(parts[3]);
                Genre genre = Genre.valueOf(parts[4]);

                moviesList.add(new Movie(id, title, director, genre, status));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No saved watchlist found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error loading watchlist: " + e.getMessage());
        }

        return moviesList;
    }

    public static void saveToFile(List<Movie> movies) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Movie movie : movies) {
                writer.write(movie.getId() + ";" + 
                    movie.getTitle() + ";" + 
                    movie.getDirector() + ";" + 
                    movie.getStatus().name() + ";" + 
                    movie.getGenre().name());

                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing watchlist: " + e.getMessage());
        }
    }
}
