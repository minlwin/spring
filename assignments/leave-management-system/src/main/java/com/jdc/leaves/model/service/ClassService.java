package com.jdc.leaves.model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.jdc.leaves.model.dto.input.ClassForm;
import com.jdc.leaves.model.dto.output.ClassDetailsVO;
import com.jdc.leaves.model.dto.output.ClassListVO;

public class ClassService {

	public ClassService() {
	}

	public List<ClassListVO> search(Optional<String> teacher, Optional<LocalDate> from, Optional<LocalDate> to) {
		// TODO implement here
		return null;
	}

	public ClassForm findById(int id) {
		// TODO implement here
		return null;
	}

	public int save(ClassForm form) {
		// TODO implement here
		return 0;
	}

	public ClassDetailsVO findDetailsById(int id) {
		// TODO implement here
		return null;
	}

}