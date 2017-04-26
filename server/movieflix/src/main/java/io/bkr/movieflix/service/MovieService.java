package io.bkr.movieflix.service;

import java.util.List;

import io.bkr.movieflix.entity.Movie;

public interface MovieService {

	public Movie createMovie(Movie movie);	
	public Movie updateMovie(String movieId, Movie movie);
	public void deleteMovie(String movieId);
	public List<Movie> findAll();
	public Movie findByMovieId(String movieId);
	public Movie findByTitle(String title);
	public List<Movie> findByType(String type);
	public List<Movie> findByYear(String year);
	public List<Movie> findByGenre(String genre);
	public List<Movie> findByTypeGenre(String type, String genre);
	public List<Movie> sortAllByYear();
	public List<Movie> sortByYearType(String type);
	public List<Movie> sortByImdbRating(String year);
	public double getAvgRating(String movieId);
	}
