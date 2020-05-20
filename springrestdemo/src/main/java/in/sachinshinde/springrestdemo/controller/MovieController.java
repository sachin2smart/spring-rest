package in.sachinshinde.springrestdemo.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sachinshinde.springrestdemo.model.Movie;

/*
 * 		Creation of REST endpoint with optional parameters 
 */

@RestController
public class MovieController {
	@GetMapping("/getMovieDetails")
	public ArrayList<Movie> getMovies() {
		
		ArrayList<Movie> movies = new ArrayList<Movie>(2);
		
		Movie m1 = new Movie();
		m1.setId(10194);
		m1.setName("Toy Story");
		m1.setGenres("Comedy");
		m1.setBudget(30000000);
		m1.setImdbRating(7.7);
		
		Movie m2 = new Movie(12,"Jumanji","Adventure",65000000,6.9);
		
		movies.add(m1);
		movies.add(m2);
		
		return movies;
	}
}
