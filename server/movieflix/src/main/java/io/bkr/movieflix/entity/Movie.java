package io.bkr.movieflix.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Movie.getAll", query="SELECT mv FROM Movie mv ORDER BY mv.title ASC"),
	@NamedQuery(name="Movie.getByTitle", query="SELECT mv FROM Movie mv WHERE mv.title=:pTitle"),
	@NamedQuery(name="Movie.getByYear", query="SELECT mv FROM Movie mv WHERE mv.year=:pYear "),
	@NamedQuery(name="Movie.getByGenre", query="SELECT mv FROM Movie mv WHERE mv.genre=:pGenre"),
	@NamedQuery(name="Movie.getByType", query="SELECT mv FROM Movie mv WHERE mv.type=:pType"),
	@NamedQuery(name="Movie.sortByYear", query="SELECT mv FROM Movie mv ORDER BY mv.year DESC")
})

public class Movie {
	
	@Override
	public String toString() {
		return "Movie [MovieId=" + MovieId + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released="
				+ released + ", runtime=" + runtime + ", genre=" + genre + ", cast=" + cast + ", plot=" + plot
				+ ", language=" + language + ", country=" + country + ", awards=" + awards + ", poster=" + poster
				+ ", metaScore=" + metaScore + ", imdbRating=" + imdbRating + ", imdbVotes=" + imdbVotes + ", imdbId="
				+ imdbId + ", type=" + type + "]";
	}
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator ="customUUID")
	String MovieId;
	
	@Column(unique = true)
	String title;
    int year;
    String rated;
    String released;
    String runtime;
    
    @LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
    List<Genre> genre;
    
    @LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
    List<CastCrew> cast;
    String plot;
    String language;
    String country;
    String awards;
    String poster;
    int metaScore;
    float imdbRating;
    double imdbVotes;
    String imdbId;
    String type;
    
    public String getMovieId() {
		return MovieId;
	}
	public void setMovieId(String movieId) {
		MovieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public String getReleased() {
		return released;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public List<Genre> getGenre() {
		return genre;
	}
	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}
	public List<CastCrew> getCast() {
		return cast;
	}
	public void setCast(List<CastCrew> cast) {
		this.cast = cast;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getMetaScore() {
		return metaScore;
	}
	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}
	public float getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}
	public double getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(double imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
