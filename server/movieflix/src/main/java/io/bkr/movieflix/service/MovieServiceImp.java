package io.bkr.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.bkr.movieflix.entity.CastCrew;
import io.bkr.movieflix.entity.Genre;
import io.bkr.movieflix.entity.Movie;
import io.bkr.movieflix.exception.DataAlreadyExistsException;
import io.bkr.movieflix.exception.NoDataFoundException;
import io.bkr.movieflix.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService{

	@Autowired
	MovieRepository repository;
	
	@Autowired
	CastCrewService castService;
	
	@Autowired
	GenreService genreService;
	
	@Autowired 
	UserReviewService  userReviewService;
	
	@Override
	@Transactional
	public Movie createMovie(Movie movie) {
		Movie existing=repository.findByTitle(movie.getTitle());
		if(existing != null){
			throw new DataAlreadyExistsException("Movie Already Exists!!");
		}
		List<CastCrew> cast = movie.getCast();
		castService.createCastCrew(cast);
	 
		List<Genre> genre = movie.getGenre();
	    genreService .createGenre(genre); 
	    return repository.createMovie(movie);
	}

	@Override
	@Transactional
	public Movie updateMovie(String movieId, Movie movie) {
		Movie existing=repository.findByMovieId(movieId);
		
		if (existing== null){
			throw new NoDataFoundException(movie + "With Id:" + movieId + "Does Not Exists!");
		}
		List<CastCrew> cast = existing.getCast();
		castService.updateCastCrew(cast);
	 
		List<Genre> genre = existing.getGenre();
	    genreService .updateGenre(genre);
	    
		return repository.updateMovie(movie);
	}

	@Override
	@Transactional
	public void deleteMovie(String movieId) {
		Movie existing = repository.findByMovieId(movieId);
		if (existing== null){
			throw new NoDataFoundException("Movie Does Not Exists!");
		}
		List<CastCrew> cast = existing.getCast();
		castService.deleteCast(cast);
	 
		List<Genre> genre = existing.getGenre();
	    genreService .deleteGenre(genre);
	    
		repository.deleteMovie(existing);
	}

	@Override
	@Transactional
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findByMovieId(String movieId) {
		Movie existing=repository.findByMovieId(movieId);
		if(existing==null){
			throw new NoDataFoundException("ID:" + movieId + " Does not Exists!");
		}
		return existing;
	}

	@Override
	public Movie findByTitle(String title) {
		Movie existing=repository.findByTitle(title);
		if(existing==null){
			throw new NoDataFoundException("Title:"+ title +" Does not Exists!");
		}
		return existing;	
	}

	@Override
	@Transactional
	public List<Movie> findByType(String type) {
		return repository.findByType(type);	
	}

	@Override
	@Transactional
	public List<Movie> findByYear(String year) {
		return repository.findByYear(year);
	}

	@Override
	@Transactional
	public List<Movie> findByGenre(String genre) {
		return repository.findByGenre(genre);
	}

	@Override
	public List<Movie> findByTypeGenre(String type, String genre) {
		return repository.findByTypeGenre(type, genre);
	}

	@Override
	public List<Movie> sortAllByYear() {
		return repository.sortAllByYear();
	}

	@Override
	public List<Movie> sortByYearType(String type) {
		return repository.sortByYearType(type);
	}

	@Override
	public List<Movie> sortByImdbRating(String type) {
		return repository.sortByImdbRating(type);
	}

	@Override
	public double getAvgRating(String movieId) {
		Movie movie=repository.findByMovieId(movieId);
		return  userReviewService.getAverageRating(movie);
	}

		
}
