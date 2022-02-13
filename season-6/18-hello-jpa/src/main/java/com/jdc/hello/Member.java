package com.jdc.hello;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;

@Entity
@SecondaryTables({ @SecondaryTable(name = "contact"), @SecondaryTable(name = "facebook") })
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String loginId;
	private String name;
	@Basic(fetch = LAZY, optional = true)
	private String password;
	private LocalDate startDate;
	
	@Embedded
	@AttributeOverrides({ 
		@AttributeOverride(name = "name", column = @Column(name = "father_name", table = "Member")),
		@AttributeOverride(name = "phone", column = @Column(name = "father_phone", table = "Member")),
		@AttributeOverride(name = "job", column = @Column(name = "father_job", table = "Member")) 
	})
	private Parent father;

	@Embedded
	@AttributeOverrides({ 
		@AttributeOverride(name = "name", column = @Column(name = "mother_name", table = "Member")),
		@AttributeOverride(name = "phone", column = @Column(name = "mother_phone", table = "Member")),
		@AttributeOverride(name = "job", column = @Column(table = "Member", name = "mother_job")) 
	})
	private Parent mother;

	@Lob
	private String greeting;

	@Transient
	private boolean checked;

	@Column(name = "display_order")
	private int order;

	@Temporal(DATE)
	private Date dob;

	@Enumerated(STRING)
	private Role role;

	@Column(table = "contact")
	private String email;
	@Column(table = "contact")
	private String phone;

	@Column(table = "facebook")
	private String fbAccountName;
	@Column(table = "contact")
	private String profileUrl;
	
	private SecurityInfo security = new SecurityInfo();

	public enum Role {
		Admin, Member
	}

	public String getLoginId() {
		return loginId;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFbAccountName() {
		return fbAccountName;
	}

	public void setFbAccountName(String fbAccountName) {
		this.fbAccountName = fbAccountName;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public SecurityInfo getSecurity() {
		return security;
	}

	public void setSecurity(SecurityInfo security) {
		this.security = security;
	}

	public Parent getFather() {
		return father;
	}

	public void setFather(Parent father) {
		this.father = father;
	}

	public Parent getMother() {
		return mother;
	}

	public void setMother(Parent mother) {
		this.mother = mother;
	}

}
