package com.jdc.spring.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Profile {

	@Id
	private Integer id;
	
	@NonNull
	@OneToOne
	@MapsId
	@PrimaryKeyJoinColumn
	private Account account;
	
	@NonNull
	private LocalDate dob;
	private String image;
	private String introduction;
	
	@Version
	private int version;
}
