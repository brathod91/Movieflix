package io.bkr.movieflix.repository;

import java.util.List;

import io.bkr.movieflix.entity.Genre;

public interface GenreRepository {
	public List<Genre> createGenre(List<Genre> genre);
	public List<Genre> updateGenre(List<Genre> genre);
	public void deleteGenre(List<Genre> genre);
	public Genre getGenre(String genreId);
	public List<Genre> getGenreByName(String gname);

}
