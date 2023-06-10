package com.jdc.location.model.repo.custom;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

@Transactional(readOnly = true)
public class BaseRepositoryDefault<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

	private EntityManager entityManager;
	
	public BaseRepositoryDefault(JpaEntityInformation<T, Object> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public List<T> search(String jpql, Map<String, Object> params) {
		var query = entityManager.createQuery(jpql, getDomainClass());
		for(var entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

}
