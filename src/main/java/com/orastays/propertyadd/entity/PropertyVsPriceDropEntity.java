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
@Table(name = "property_vs_pricedrop")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PropertyVsPriceDropEntity extends CommonEntity  {

	private static final long serialVersionUID = -4060990897006224027L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_pricedrop_id")
	@JsonProperty("propertyPDropId")
	private Long propertyPDropId;

	@Column(name = "percentage")
	@JsonProperty("percentage")
	private String percentage;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "property_id", nullable = false)
	@JsonProperty("property")
	private PropertyEntity propertyEntity;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "price_drop_id", nullable = false)
	@JsonProperty("priceDrop")
	private PriceDropEntity priceDropEntity;
	
	@Override
	public String toString() {
		return Long.toString(propertyPDropId);
	}
}