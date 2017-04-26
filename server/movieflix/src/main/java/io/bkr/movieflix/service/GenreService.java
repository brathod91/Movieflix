package io.bkr.movieflix.service;

import java.util.List;

import io.bkr.movieflix.entity.Genre;

public interface GenreService {
	public List<Genre> createGenre(List<Genre> genre);
	public List<Genre> updateGenre(List<Genre> genre);
	public void deleteGenre(List<Genre> genre);
	public Genre getGenre(String genreId);
	public List<Genre> getGenreByName(String gname);

}
