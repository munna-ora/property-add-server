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
@Table(name = "master_price_drop")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PriceDropEntity extends CommonEntity {

	private static final long serialVersionUID = 4697022789596398163L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "price_drop_id")
	@JsonProperty("priceDropId")
	private Long priceDropId;

	@Column(name = "after_time")
	@JsonProperty("afterTime")
	private String afterTime;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "priceDropEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertyVsPriceDrops")
	private List<PropertyVsPriceDropEntity> propertyVsPriceDropEntities;

	@Override
	public String toString() {
		return Long.toString(priceDropId);
	}

}
