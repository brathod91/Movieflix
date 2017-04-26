package io.bkr.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.bkr.movieflix.entity.Movie;
import io.bkr.movieflix.entity.UserReview;
import io.bkr.movieflix.entity.Users;
import io.bkr.movieflix.exception.DataAlreadyExistsException;
import io.bkr.movieflix.exception.NoDataFoundException;
import io.bkr.movieflix.repository.UserReviewRepository;

@Service
public class UserReviewServiceImp implements UserReviewService {

	@Autowired
	UserReviewRepository repository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MovieService movieService;
	
	@Override
	@Transactional
	public UserReview createReview(UserReview userReview) {
		
		String userId=userReview.getUser().getUserId();
		String movieId=userReview.getMovie().getMovieId();
				
		Users user= userService.getUserbyId(userId);
		Movie movie=movieService.findByMovieId(movieId);
		if(movie != null && user != null){
			UserReview existing=repository.getReviewByUserMovie(movie, user);
			
			if(existing!= null){
				throw new DataAlreadyExistsException("Review by" + userId + "Already Exists!");
			}
			else{
				userReview.setMovie(movie);
				userReview.setUser(user);
				return repository.createReview(userReview);
			}
		}
		else{
			throw new NoDataFoundException("Movie or User Does not Exists!");
		}
	}

	@Override
	@Transactional
	public UserReview updateUserReview(String userReviewId, UserReview userReview) {
		String userId=userReview.getUser().getUserId();
		String movieId=userReview.getMovie().getMovieId();
			
		UserReview existing=repository.getReviewById(userReviewId);
			
			if(existing!= null){
				throw new NoDataFoundException("Movie or User Does not Exists!");
			}
			else{
				Users user= userService.getUserbyId(userId);
				Movie movie=movieService.findByMovieId(movieId);
				
				userService.updateUser(userId, user);
				movieService.updateMovie(movieId, movie);
				return repository.updateUserReview(userReview);
			}
	}

	@Override
	@Transactional
	public void deleteUserReviewbyId(String userReviewId) {
		UserReview existing=repository.getReviewById(userReviewId);
		if(existing == null){
			throw new NoDataFoundException("Review does not exists!");
		}
		repository.deleteUserReview(existing);
	}

	@Override
	@Transactional
	public void deleteUserReview(String userId, String movieId) {
		Users user= userService.getUserbyId(userId);
		Movie movie=movieService.findByMovieId(movieId);
		UserReview existing=repository.getReviewByUserMovie(movie, user);
		
		if(existing == null){
			throw new NoDataFoundException("Review does not exists!");
		}
		repository.deleteUserReview(existing);
	}
	
	@Override
	@Transactional
	public List<UserReview> getAllReview() {
		return repository.getAllReview();
	}

	@Override
	public UserReview getReviewByUserMovie(String movieId, String userId) {
		Users user= userService.getUserbyId(userId);
		Movie movie=movieService.findByMovieId(movieId);
		return repository.getReviewByUserMovie(movie, user);
	}

	@Override
	public Double getAverageRating(Movie movie) {
		return repository.getAverageRating(movie);
	}

	

	
}
