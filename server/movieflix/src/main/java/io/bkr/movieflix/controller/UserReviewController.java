package io.bkr.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.bkr.movieflix.entity.UserReview;
import io.bkr.movieflix.service.UserReviewService;

@RestController
@RequestMapping(path = "reviews")
public class UserReviewController {

	@Autowired
	UserReviewService service;
	
	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserReview createReview(@RequestBody UserReview userReview){
		return service.createReview(userReview);
	}
	
	@RequestMapping(method = RequestMethod.PUT,path = "{userReviewId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserReview updateUserReview(@PathVariable("userReviewId") String userReviewId, @RequestBody UserReview userReview){
		return service.updateUserReview(userReviewId, userReview);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path={"userReviewId"})
	public void deleteUserReviewbyId(@PathVariable("userReviewId") String userReviewId){
		service.deleteUserReviewbyId(userReviewId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path="{userid}/{movieId}")
	public void deleteUserReview(@PathVariable("userReviewId") String userId, @PathVariable("userReviewId") String movieId){
		service.deleteUserReview(userId,movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserReview> getAllReview(){
		return service.getAllReview();
	}
	
	@RequestMapping(method = RequestMethod.GET,path="{mid}/{uid}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserReview getReviewByUserMovie(@PathVariable("mid") String movieId,@PathVariable("uid") String userId){
		return service.getReviewByUserMovie(movieId,userId);
	}
}
