package io.bkr.movieflix.repository;

import java.util.List;

import io.bkr.movieflix.entity.CastCrew;

public interface CastCrewRepository {

	public List<CastCrew> createCastCrew(List<CastCrew> cast);
	public List<CastCrew> updateCastCrew(List<CastCrew> cast);
	public void deleteCast(List<CastCrew> cast);
	public CastCrew getCast(String castId);
}
