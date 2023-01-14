package com.jdc.location.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.entity.District;
import com.jdc.location.model.entity.District_;
import com.jdc.location.model.entity.State;
import com.jdc.location.model.entity.State_;
import com.jdc.location.model.repo.StateRepo;

@Service
@Transactional(readOnly = true)
public class SubQueryDemoService {

	@Autowired
	private StateRepo repo;
	
	public List<State> search(String name) {
		
		/*
		 * select s from State where s.id 
		 * in (select d.state.id from District d where d.name like ?)
		 */
		Specification<State> spec = (root, query, cb) -> {
			var sub = query.subquery(Integer.class);
			var district = sub.from(District.class);
			sub.select(district.get(District_.state).get(State_.id));
			sub.where(
					cb.like(cb.lower(district.get(District_.name)), 
					name.toLowerCase().concat("%")));
			
			return root.get(State_.id).in(sub);
		};
		
		return repo.findAll(spec);
	}
}
