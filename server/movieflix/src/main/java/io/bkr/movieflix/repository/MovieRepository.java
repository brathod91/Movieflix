package io.bkr.movieflix.repository;

import java.util.List;

import io.bkr.movieflix.entity.Movie;

public interface MovieRepository {

	public Movie createMovie(Movie movie);	
	public Movie updateMovie(Movie movie);
	public void deleteMovie(Movie movie);
	public List<Movie> findAll();
	public Movie findByMovieId(String movieId);
	public Movie findByTitle(String title);
	public List<Movie> findByType(String type);
	public List<Movie> findByYear(String year);
	public List<Movie> findByGenre(String genre);
	public List<Movie> findByTypeGenre(String type, String genre);
	public List<Movie> sortAllByYear();
	public List<Movie> sortByYearType(String type);
	public List<Movie> sortByImdbRating(String type);
}
