package io.bkr.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.bkr.movieflix.entity.CastCrew;

@Repository
public class CastCrewRepositoryImp implements CastCrewRepository{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<CastCrew> createCastCrew(List<CastCrew> cast) {
		for(CastCrew cst: cast){
			em.persist(cst);
		}
		return cast;
	}

	@Override
	public List<CastCrew> updateCastCrew(List<CastCrew> cast) {
		for(CastCrew cst: cast){
			em.merge(cst);
		}
		return cast;
	}

	@Override
	public void deleteCast(List<CastCrew> cast) {
		for(CastCrew cst: cast){
			em.remove(cst);
		}
	}

	@Override
	public CastCrew getCast(String castId) {
		return em.find(CastCrew.class, castId);
	}

}
