package patterns.singleton;

import java.util.ArrayList;
import java.util.List;
import models.Movie;

public class TheaterManager {
    private static TheaterManager instance;
    private final List<Movie> movies;

    private TheaterManager() {
        movies = new ArrayList<>();
    }

    public static synchronized TheaterManager getInstance() {
        if (instance == null) {
            instance = new TheaterManager();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }
}
