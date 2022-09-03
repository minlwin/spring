package com.jdc.leaves.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.leaves.model.dto.input.RegistrationForm;
import com.jdc.leaves.model.dto.output.RegistrationDetailsVO;
import com.jdc.leaves.model.dto.output.RegistrationListVO;

@Service
public class RegistrationService {

	public List<RegistrationListVO> searchByClassId(int id) {
		// TODO implement here
		return List.of();
	}

	public int save(RegistrationForm form) {
		// TODO implement here
		return 0;
	}

	public RegistrationDetailsVO findDetailsById(int id) {
		// TODO implement here
		return null;
	}

	public RegistrationForm getFormById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}