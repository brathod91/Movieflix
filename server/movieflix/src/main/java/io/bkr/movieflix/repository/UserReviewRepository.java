package io.bkr.movieflix.repository;

import java.util.List;

import io.bkr.movieflix.entity.Movie;
import io.bkr.movieflix.entity.UserReview;
import io.bkr.movieflix.entity.Users;

public interface UserReviewRepository {

	public UserReview createReview(UserReview userReview);
	public UserReview updateUserReview(UserReview userReview);
	public void deleteUserReview(UserReview userReview);
	public List<UserReview> getAllReview();
	public UserReview getReviewById(String userReviewId);
	public UserReview getReviewByUserMovie(Movie movie, Users user);
	public Double getAverageRating(Movie movie);
}
