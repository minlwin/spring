package com.jdc.leaves.model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.leaves.model.dto.input.LeaveForm;
import com.jdc.leaves.model.dto.output.LeaveListVO;
import com.jdc.leaves.model.dto.output.LeaveSummaryVO;

@Service
public class LeaveService {

	public List<LeaveListVO> search(Optional<Integer> classId, Optional<String> studentName, Optional<LocalDate> from, Optional<LocalDate> to) {
		// TODO implement here
		return List.of();
	}

	public LeaveForm findById(LocalDate applyDate, int classId, int studentId) {
		// TODO implement here
		return null;
	}

	@Transactional
	public void save(LeaveForm form) {
		// TODO implement here
	}

	public List<LeaveSummaryVO> searchSummary(Optional<LocalDate> target) {
		// TODO implement here
		return null;
	}

}