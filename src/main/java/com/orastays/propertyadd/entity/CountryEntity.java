package com.orastays.propertyadd.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_country")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class CountryEntity extends CommonEntity {

	private static final long serialVersionUID = 1720137711942757387L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	@JsonProperty("countryId")
	private Long countryId;

	@Column(name = "country_code")
	@JsonProperty("countryCode")
	private String countryCode;
	
	@Column(name = "country_name")
	@JsonProperty("countryName")
	private String countryName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "countryEntity", cascade = { CascadeType.ALL })
	@JsonProperty("states")
	private List<StateEntity> stateEntities;
	
	@Override
	public String toString() {
		return Long.toString(countryId);
	}

}
