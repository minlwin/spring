package com.jdc.location.model.repo.custom;

import java.util.HashMap;
import java.util.List;

import org.springframework.util.StringUtils;

import com.jdc.location.model.entity.State;
import com.jdc.location.model.entity.State.Type;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class StateCustomRepoDefault implements StateCustomRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<State> search(Type type, String region, String name) {
		
		var sb = new StringBuffer("select s from State s where 1 = 1");
		var params = new HashMap<String, Object>();
		
		if(null != type) {
			sb.append(" and s.type = :type");
			params.put("type", type);
		}
		
		if(StringUtils.hasLength(region)) {
			sb.append(" and s.region = :region");
			params.put("region", region);
		}
		
		if(StringUtils.hasLength(name)) {
			sb.append(" and lower(s.name) like lower(:name)");
			params.put("name", name.concat("%"));
		}
		
		var query = em.createQuery(sb.toString(), State.class);
		for(var entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		return query.getResultList();
	}

}
