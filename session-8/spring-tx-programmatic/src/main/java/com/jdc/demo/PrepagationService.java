package com.jdc.demo;

import org.springframework.stereotype.Service;

import com.jdc.demo.repo.DeatilsRepository;
import com.jdc.demo.repo.HeaderRepository;

@Service
public class PrepagationService {

	private HeaderRepository headerRepository;
	
	private DeatilsRepository detailsRepository;
	
	public Result save(int state, String header, String ... details) {
		
		// create header
		var headerId = headerRepository.create(header);
		
		if(state == 1) {
			throw new RuntimeException();
		}
		
		
		// create details
		var detailsIds = detailsRepository.create(headerId, details);
		
		if(state == 2) {
			throw new RuntimeException();
		}
		
		return new Result(headerId, detailsIds);
	}
	
}
