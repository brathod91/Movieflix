package io.bkr.movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Genre.getGenreByType", query="Select g from Genre g where g.genreType=:pType")
})
public class Genre {
	
	@Id
	@GenericGenerator(name="customUUID", strategy="uuid2")
	@GeneratedValue(generator="customUUID")
	String genreId;
	
	String genreType;
	
	public String getGenreId() {
		return genreId;
	}
	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}
	public String getGenreType() {
		return genreType;
	}
	public void setGenreType(String genreType) {
		this.genreType = genreType;
	}
	
	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreType=" + genreType + "]";
	}
}
