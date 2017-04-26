package io.bkr.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.bkr.movieflix.entity.Movie;
import io.bkr.movieflix.entity.UserReview;
import io.bkr.movieflix.entity.Users;

@Repository
public class UserReviewRepositoryImp implements UserReviewRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public UserReview createReview(UserReview userReview) {
		em.persist(userReview);
		return userReview;
	}

	@Override
	public UserReview updateUserReview(UserReview userReview) {
		em.merge(userReview);
		return userReview;
	}

	@Override
	public void deleteUserReview(UserReview userReview) {
		em.remove(userReview);
	}
	
	@Override
	public List<UserReview> getAllReview() {
		TypedQuery<UserReview> query=em.createNamedQuery("UserReview.getAll",UserReview.class);
		return query.getResultList();
	}

	@Override
	public Double getAverageRating(Movie movie) {
		Query query=em.createQuery("Select AVG(ur.rating) from UserReview ur where ur.movie=:pMovie");
		query.setParameter("pMovie", movie);
		Double result=(Double) query.getSingleResult();
		return result;
	}

	
	@Override
	public UserReview getReviewById(String userReviewId) {
		return em.find(UserReview.class, userReviewId);
	}

	@Override
	public UserReview getReviewByUserMovie(Movie movie, Users user) {
		TypedQuery<UserReview> query=em.createNamedQuery("UserReview.getRewviewByUserMovie",UserReview.class);
		query.setParameter("pUser", user);
		query.setParameter("pMovie", movie);
		
		List<UserReview> ur=query.getResultList();
		if (ur!=null && ur.size()==1){
			return ur.get(0);
		}
		return null;
	}

}
