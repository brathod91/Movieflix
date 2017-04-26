package io.bkr.movieflix.service;

import java.util.List;

import io.bkr.movieflix.entity.Movie;
import io.bkr.movieflix.entity.UserReview;

public interface UserReviewService {

	public UserReview createReview(UserReview userReview);
	public UserReview updateUserReview(String userReviewId,UserReview userReview);
	public void deleteUserReviewbyId(String userReviewId);
	public void deleteUserReview(String userId, String movieId);
	public List<UserReview> getAllReview();
	public UserReview getReviewByUserMovie(String movieId,String userId);
	public Double getAverageRating(Movie movie);
}
