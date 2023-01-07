package com.jdc.location.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.entity.District;
import com.jdc.location.model.entity.State;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class StateCriteriaService {

	@PersistenceContext
	private EntityManager entityManager;
	
	// select s from State s where s.region = region
	public List<State> findByRegion(String region) {
		
		// Create Criteria Builder
		var criteriaBuilder = entityManager.getCriteriaBuilder();
		
		// Create Criteria Query
		var criteriaQuery = criteriaBuilder.createQuery(State.class);
		
		// Create Root Object
		var root = criteriaQuery.from(State.class);
		
		// select s from State s
		criteriaQuery.select(root);
		
		// s.region = region
		var predicate = criteriaBuilder.equal(root.get("region"), region);
		
		// select s from State s where s.region = region
		criteriaQuery.where(predicate);
		
		// execute query
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	
	@Transactional
	public long deleteByRegion(String region) {
		
		// Create Criteria Builder
		var criteriaBuilder = entityManager.getCriteriaBuilder();
		
		deleteDistrictByRegion(region);
		
		var delete = criteriaBuilder.createCriteriaDelete(State.class);
		var root = delete.from(State.class);
		delete.where(criteriaBuilder.equal(root.get("region"), region));
		
		return entityManager.createQuery(delete).executeUpdate();
	}


	private long deleteDistrictByRegion(String region) {
		// Create Criteria Builder
		var criteriaBuilder = entityManager.getCriteriaBuilder();
		
		var delete = criteriaBuilder.createCriteriaDelete(District.class);
		var root = delete.from(District.class);
		
		delete.where(criteriaBuilder.equal(root.get("state").get("region"), region));
		
		return entityManager.createQuery(delete).executeUpdate();
	}
}
