package com.jdc.location.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.location.model.entity.District;
import com.jdc.location.model.entity.District_;
import com.jdc.location.model.entity.State_;
import com.jdc.location.model.repo.DistrictRepo;

@Service
public class DistrictSpecService {

	@Autowired
	private DistrictRepo repo;
	
	public List<District> searchByRegion(String region) {
		
		return repo.findAll((root, query, cb) -> {
			// order by d.name desc
			query.orderBy(cb.desc(root.get(District_.name)));
			// d.state.region = ?
			return cb.equal(root.get(District_.state).get(State_.region), region);
		});
	}
	
	public List<District> searchByRegion(String region, Sort sort) {
		return repo.findBy(forRegion(region), 
					query -> query.sortBy(sort).all());
	}
	
	public Page<District> searchByRegion(String region, Pageable page) {
		return repo.findBy(forRegion(region), query -> query.page(page));
	}
	
	private Specification<District> forRegion(String region) {
		return (root, query, cb) -> cb.equal(root.get(District_.state).get(State_.region), region);
	}
}
