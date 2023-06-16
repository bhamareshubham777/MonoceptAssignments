package com.techlabs.assignment;
import java.util.List;
import java.util.Scanner;

public class MovieController {
    private MovieManager manager;

    public MovieController() {
        manager = new MovieManager();
    }

    public void start() {
        displayMenu();
    }

    private void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean status = true;

        do {
            System.out.println("===Movie Store Menu===");
            System.out.println("1. Add Movie");
            System.out.println("2. Clear Movies");
            System.out.println("3. View Movies");
            System.out.println("4. View Movie by Id");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice=scanner.nextInt();
            
            switch (choice) {
			case 1:
				Movie movie=setMovieDetails();
				manager.addMovie(movie);
				break;
			case 2:
				manager.clearMovies();
				break;
			case 3:
				List<Movie> movies = manager.getMovies();
				if(movies.isEmpty()) {
					System.out.println("No movies found!!");
				}
				if(!movies.isEmpty()) {
					for(Movie movie1 : movies) {
						System.out.println(movie1);
					}
				}
				break;
			case 4:
				System.out.println("Enter Id to view movie:");
				int id=scanner.nextInt();
				Movie movieById=manager.getMovieById(id);
				System.out.println(movieById);
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid Choice");
			}
        }while(status);
        
    }

	private Movie setMovieDetails() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Movie Details:");
		System.out.println("Enter id");
		int id=scanner.nextInt();
		System.out.println("Enter Name:");
		String name=scanner.next();
		System.out.println("Enter Year:");
		int year=scanner.nextInt();
		System.out.println("Enter Genre");
		String genre=scanner.next();
		
		Movie movie=new Movie(id, name, year, genre);
		return movie;
	}
}
