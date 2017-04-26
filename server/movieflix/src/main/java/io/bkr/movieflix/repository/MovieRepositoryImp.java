package io.bkr.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.bkr.movieflix.entity.Movie;

@Repository
public class MovieRepositoryImp implements MovieRepository{

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Movie createMovie(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		em.merge(movie);
		return movie;
	}

	@Override
	public void deleteMovie(Movie movie) {
		em.remove(movie);
	}

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query=em.createNamedQuery("Movie.getAll",Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findByMovieId(String movieId) {
		return em.find(Movie.class, movieId);
	}

	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query=em.createNamedQuery("Movie.getByTitle",Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movie = query.getResultList();
		if (movie != null && movie.size()==1){
			return movie.get(0);
		}
		return null;
	}

	@Override
	public List<Movie> findByType(String type) {
		TypedQuery<Movie> query=em.createNamedQuery("Movie.getByType",Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}

	@Override
	public List<Movie> findByYear(String year) {
		TypedQuery<Movie> query=em.createNamedQuery("Movie.getByYear",Movie.class);
		query.setParameter("pYear", year);
		return query.getResultList();
	}

	@Override
	public List<Movie> findByGenre(String genre) {
		TypedQuery<Movie> query=em.createNamedQuery("Movie.getByGenre",Movie.class);
		query.setParameter("pGenre", genre);
		return query.getResultList();
	}

	@Override
	public List<Movie> findByTypeGenre(String type, String genre) {
		TypedQuery<Movie> query=em.createQuery("SELECT mv FROM Movie mv WHERE mv.type=:pType AND mv.genre=:pGenre",Movie.class);
		query.setParameter("pType", type);
		query.setParameter("pGenre", genre);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortAllByYear() {
		TypedQuery<Movie> query=em.createNamedQuery("Movie.sortByYear",Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortByYearType(String type) {
		TypedQuery<Movie> query=em.createQuery("SELECT mv FROM Movie mv WHERE mv.type=:ptype ORDER BY mv.year DESC",Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortByImdbRating(String type) {
		TypedQuery<Movie> query=em.createQuery("SELECT mv FROM Movie mv WHERE mv.type=:ptype ORDER BY mv.imdbRating DESC",Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}

}
