package com.jdc.leaves.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdc.leaves.model.dto.input.TeacherForm;
import com.jdc.leaves.model.dto.output.TeacherListVO;

@Service
public class TeacherService {

	public List<TeacherListVO> search(Optional<String> name, Optional<String> phone, Optional<String> email) {
		// TODO implement here
		return List.of();
	}

	public TeacherListVO findById(int id) {
		// TODO implement here
		return null;
	}

	public int save(TeacherForm form) {
		// TODO implement here
		return 0;
	}

}