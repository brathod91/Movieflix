package io.bkr.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.bkr.movieflix.entity.Movie;
import io.bkr.movieflix.service.MovieService;

@RestController
@RequestMapping(path = "movie")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@RequestMapping(method = RequestMethod.POST, path="createMovie",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie createMovie(@RequestBody Movie movie){
		return service.createMovie(movie);
	}
	
	@RequestMapping(method = RequestMethod.PUT,path = "{mid}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie updateMovie(@PathVariable("mid") String movieId, @RequestBody Movie movie){
		return service.updateMovie(movieId, movie);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path={"mid"})
	public void deleteMovie(@PathVariable String movieId){
		service.deleteMovie(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll(){
		return service.findAll();
	} 

	@RequestMapping(method = RequestMethod.GET, path="findByMovieId/{mid}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findByMovieId(@PathVariable("mid") String movieId){
		return service.findByMovieId(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="findByTitle/{tnm}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findByTitle(@PathVariable("tnm") String title){
		return service.findByTitle(title);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="findByType/{ty}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByType(@PathVariable("ty") String type){
		return service.findByType(type);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="findByYear/{yr}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByYear(@PathVariable("yr") String year){
		return service.findByYear(year);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="findByGenre/{gn}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByGenre(@PathVariable("gn") String genre){
		return service.findByGenre(genre);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="findByTypeGenre/{type}/{genre}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByTypeGenre(@PathVariable("type") String type, @PathVariable("genre") String genre){
		return service.findByTypeGenre(type, genre);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="sortAllByYear",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortAllByYear(){
		return service.sortAllByYear();
	}
	
	@RequestMapping(method = RequestMethod.GET, path="sortAllByYearType/{type}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByYearType(@PathVariable("type") String type){
		return service.sortByYearType(type);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="sortByImdbRating/{type}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByImdbRating(@PathVariable("type") String type){
		return service.sortByImdbRating(type);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="getAvgRating/{mid}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public double getAvgRating(@PathVariable("mid") String movieId){
		return service.getAvgRating(movieId);
	}
	
}
