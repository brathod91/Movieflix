package io.bkr.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.bkr.movieflix.entity.Genre;

@Repository
public class GenreRepositoryImp implements GenreRepository {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Genre> createGenre(List<Genre> genre) {
		for(Genre gnr: genre){
			em.persist(gnr);
		}
		return genre;
	}

	@Override
	public List<Genre> updateGenre(List<Genre> genre) {
		for(Genre gnr: genre){
			em.merge(gnr);
		}
		return genre;
	}

	@Override
	public void deleteGenre(List<Genre> genre) {
		for(Genre gnr: genre){
			em.remove(gnr);
		}
		
	}

	@Override
	public Genre getGenre(String genreId) {
		return em.find(Genre.class, genreId);
	}

	@Override
	public List<Genre> getGenreByName(String gname) {
		TypedQuery<Genre> query=em.createNamedQuery("Genre.getGenreByType",Genre.class);
		query.setParameter("pGenreType", gname);
		List<Genre> genreList=query.getResultList();
		return genreList;
	}

}
