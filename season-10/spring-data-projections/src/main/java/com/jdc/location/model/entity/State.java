package com.jdc.location.model.entity;

import java.io.Serializable;
import java.util.List;

import com.jdc.location.model.record.StateWithDistrictCountRecord;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;

@Entity
@Table(name = "state")
@SqlResultSetMapping(
	name = "stateWithDistrictCountRecord",
	classes = @ConstructorResult(
		targetClass = StateWithDistrictCountRecord.class,
		columns = {
			@ColumnResult(name = "id"),
			@ColumnResult(name = "name"),
			@ColumnResult(name = "districtCount", type = Integer.class)
		}
	)	
)
@NamedNativeQuery(
	name = "State.natvieWithCountById",
	resultSetMapping = "stateWithDistrictCountRecord",
	query = """
		select s.id id, s.name name, 
		(select count(1) from district d where d.state_id = s.id) as districtCount 
		from state s where s.id = ?"""
)
public class State implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Column(nullable = false)
	private String region;
	
	@Column(nullable = false)
	private String capital;
	
	private int porpulation;

	@OneToMany(
			mappedBy = "state", 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE}, 
			orphanRemoval = true)
	private List<District> district;

	public enum Type {
		State("State"), Region("Region"), Union("Union Territory");

		private String value;

		private Type(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getPorpulation() {
		return porpulation;
	}

	public void setPorpulation(int porpulation) {
		this.porpulation = porpulation;
	}

	public List<District> getDistrict() {
		return district;
	}

	public void setDistrict(List<District> district) {
		this.district = district;
	}

}
