package com.jdc.hello.composite;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PaidPK implements Serializable{

	private static final long serialVersionUID = 1L;

	private LocalDate date;
	private int seq;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, seq);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaidPK other = (PaidPK) obj;
		return Objects.equals(date, other.date) && seq == other.seq;
	}

}
