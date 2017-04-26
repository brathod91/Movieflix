package io.bkr.movieflix.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.bkr.movieflix.entity.CastCrew;
import io.bkr.movieflix.exception.NoDataFoundException;
import io.bkr.movieflix.repository.CastCrewRepository;

@Service
public class CastCrewServiceImp implements CastCrewService{

	CastCrewRepository repository;
	
	@Override
	@Transactional
	public List<CastCrew> createCastCrew(List<CastCrew> cast) {
		return repository.createCastCrew(cast);
	}

	@Override
	@Transactional
	public List<CastCrew> updateCastCrew(List<CastCrew> cast) {
		return repository.updateCastCrew(cast);
	}

	@Override
	@Transactional
	public void deleteCast(List<CastCrew> cast) {
		repository.deleteCast(cast);
	}

	@Override
	public CastCrew getCast(String castId) {
		CastCrew existing=repository.getCast(castId);
				
		if (existing == null){
			throw new NoDataFoundException("Cast Not Found");
		}
		
		return existing;
	}

}
