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
@Table(name = "property_vs_nearby")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PropertyVsNearbyEntity extends CommonEntity  {
	
	private static final long serialVersionUID = -5665028778858595841L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_nearby_id")
	@JsonProperty("propertyNearbyId")
	private Long propertyNearbyId;

	@Column(name = "places")
	@JsonProperty("places")
	private String places;
	
	@Column(name = "latitude")
	@JsonProperty("latitude")
	private String latitude;
	
	@Column(name = "longitude")
	@JsonProperty("longitude")
	private String longitude;
	
	@Column(name = "address")
	@JsonProperty("address")
	private String address;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "property_id", nullable = false)
	@JsonProperty("property")
	private PropertyEntity propertyEntity;
	
	@Override
	public String toString() {
		return Long.toString(propertyNearbyId);
	}
}
