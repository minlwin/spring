package com.jdc.leaves.model.dto.output;

import java.util.List;

public class ClassDetailsVO {

	public ClassDetailsVO() {
	}
	
	private ClassListVO classInfo;

	private List<RegistrationListVO> registrations;

	private List<LeaveListVO> leaves;

	public ClassListVO getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassListVO classInfo) {
		this.classInfo = classInfo;
	}

	public List<RegistrationListVO> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<RegistrationListVO> registrations) {
		this.registrations = registrations;
	}

	public List<LeaveListVO> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<LeaveListVO> leaves) {
		this.leaves = leaves;
	}

}