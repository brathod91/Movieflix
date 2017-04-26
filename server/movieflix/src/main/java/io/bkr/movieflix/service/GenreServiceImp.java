package io.bkr.movieflix.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.bkr.movieflix.entity.Genre;
import io.bkr.movieflix.repository.GenreRepository;

@Service
public class GenreServiceImp implements GenreService{

	GenreRepository repository;
	
	@Override
	@Transactional
	public List<Genre> createGenre(List<Genre> genre) {
		return repository.createGenre(genre);
	}

	@Override
	@Transactional
	public List<Genre> updateGenre(List<Genre> genre) {
		return repository.updateGenre(genre);
	}

	@Override
	@Transactional
	public void deleteGenre(List<Genre> genre) {
		repository.deleteGenre(genre);
	}

	@Override
	public Genre getGenre(String genreId) {
		return repository.getGenre(genreId);
	}

	@Override
	public List<Genre> getGenreByName(String gname) {
		return repository.getGenreByName(gname);
	}

}
