package io.bkr.movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "UserReview.getAll", query = "Select ur from UserReview ur"),
	@NamedQuery(name = "UserReview.getRewviewByUserMovie", query = "Select ur from UserReview ur WHERE ur.user=:pUser AND ur.movie=:pMovie")
})

public class UserReview {

	@Override
	public String toString() {
		return "UserReview [URId=" + URId + ", movie=" + movie + ", user=" + user + ", comment=" + comment + ", rating="
				+ rating + "]";
	}
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator ="customUUID")
	String URId;
	
	@OneToOne
	Movie movie;
	
	@OneToOne
	Users user;
	
	String comment;
	float rating;
	
	public String getURId() {
		return URId;
	}
	public void setURId(String uRId) {
		URId = uRId;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
}
