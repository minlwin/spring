package com.jdc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.support.TransactionTemplate;

import com.jdc.demo.repo.DeatilsRepository;
import com.jdc.demo.repo.HeaderRepository;

@Service
public class PrepagationService {

	@Autowired
	private HeaderRepository headerRepository;
	
	@Autowired
	private DeatilsRepository detailsRepository;
	
	private TransactionTemplate txTemplate;
	
	public PrepagationService(PlatformTransactionManager txManager) {
		txTemplate = new TransactionTemplate(txManager);
		txTemplate.setPropagationBehavior(TransactionAttribute.PROPAGATION_REQUIRED);
		txTemplate.setIsolationLevel(TransactionAttribute.ISOLATION_READ_COMMITTED);
		txTemplate.setTimeout(3);
	}
	
	public Result save(int state, String header, String ... details) {
		
		return txTemplate.execute(status -> {
			// create header
			var headerId = txTemplate.execute(a -> headerRepository.create(header));
			
			if(state == 1) {
				throw new RuntimeException();
			}
			
			
			// create details
			var detailsIds = txTemplate.execute(a -> detailsRepository.create(headerId, details));
			
			if(state == 2) {
				throw new RuntimeException();
			}
			
			return new Result(headerId, detailsIds);			
		});
		
	}
	
}
