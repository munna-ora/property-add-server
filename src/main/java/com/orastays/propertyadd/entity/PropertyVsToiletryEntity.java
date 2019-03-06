package com.orastays.propertyadd.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "property_vs_toiletry")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PropertyVsToiletryEntity extends CommonEntity  {
	
	private static final long serialVersionUID = 136704694247669382L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_vs_toiletry_id")
	@JsonProperty("propertyVsToiletryId")
	private Long propertyVsToiletryId;

	@Column(name = "total")
	@JsonProperty("total")
	private String total;
	
	@Column(name = "used")
	@JsonProperty("used")
	private String used;
	
	@Column(name = "pending")
	@JsonProperty("pending")
	private String pending;
	
	@Column(name = "user_id")
	@JsonProperty("userId")
	private String userId;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "property_id", nullable = false)
	@JsonProperty("property")
	private PropertyEntity propertyEntity;
	
	@Override
	public String toString() {
		return Long.toString(propertyVsToiletryId);
	}
}
