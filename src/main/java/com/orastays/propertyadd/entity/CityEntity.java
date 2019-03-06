package com.orastays.propertyadd.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_city")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class CityEntity extends CommonEntity {

	private static final long serialVersionUID = -1048032541832747832L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	@JsonProperty("cityId")
	private Long cityId;

	@Column(name = "city_name")
	@JsonProperty("cityName")
	private String cityName;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "state_id", nullable = false)
	@JsonProperty("states")
	private StateEntity stateEntity;

	@Override
	public String toString() {
		return Long.toString(cityId);
	}

}
