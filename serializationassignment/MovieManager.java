package com.techlabs.assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movies;
    private static final String filePath = "C:\\monocept\\Assignments\\05-serialization-app\\src\\com\\techlabs\\assignment\\movies.txt";

    public MovieManager() {
        movies = new ArrayList<>();
        loadMovies();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        saveMovies();
    }

    public void clearMovies() {
        movies.clear();
        saveMovies();
        System.out.println("Movies Deleted Successfully!!!");
    }

    public List<Movie> getMovies() {
        return movies;
    }
    
    public Movie getMovieById(int id) {
    	Movie movieById = null;
    	for(Movie movie:movies) {
    		if(movie.getId()==id)
    			movieById= movie;
    	}
		return movieById;
    }

    public void loadMovies() {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            movies = (List<Movie>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading movies: " + e.getMessage());
        }
    }

    public void saveMovies() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(movies);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("Error saving movies: " + e.getMessage());
        }
    }

}

