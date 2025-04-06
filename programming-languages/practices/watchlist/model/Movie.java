package model;

public class Movie {
    private int id;
    private String title;
    private String director;
    private Genre genre;
    private Status status;

    public Movie(int id, String title, String director, Genre genre, Status status) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.status = status;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
