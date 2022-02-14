package com.jdc.hello.composite;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RegistrationPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "regist_date")
	private LocalDate date;
	@Column(name = "regist_seq")
	private int registrationId;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, registrationId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationPK other = (RegistrationPK) obj;
		return Objects.equals(date, other.date) && registrationId == other.registrationId;
	}

}
