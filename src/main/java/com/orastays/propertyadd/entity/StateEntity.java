package com.orastays.propertyadd.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_state")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class StateEntity extends CommonEntity {

	private static final long serialVersionUID = 6229323540719360502L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_id")
	@JsonProperty("stateId")
	private Long stateId;

	@Column(name = "state_name")
	@JsonProperty("stateName")
	private String stateName;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "country_id", nullable = false)
	@JsonProperty("countrys")
	private CountryEntity countryEntity;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stateEntity", cascade = { CascadeType.ALL })
	@JsonProperty("citys")
	private List<CityEntity> cityEntities;
	
	@Override
	public String toString() {
		return Long.toString(stateId);
	}

}
