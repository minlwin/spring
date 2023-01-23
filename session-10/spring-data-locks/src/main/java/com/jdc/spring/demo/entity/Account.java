package com.jdc.spring.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;
	
	@NonNull
	@Column(nullable = false)
	private String name;
	@NonNull
	@Column(nullable = false, unique = true)
	private String email;
	@NonNull
	@Column(nullable = false)
	private String password;
	@NonNull
	@Column(nullable = false)
	private Role role;
	
	@OneToOne(mappedBy = "account")
	private Profile profile;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Address> address;
	
	@Version
	private Integer version;
	
	public enum Role {
		Admin, Member
	}
}
