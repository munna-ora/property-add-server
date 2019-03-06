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
@Table(name = "property_vs_image")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PropertyVsImageEntity extends CommonEntity  {
	
	private static final long serialVersionUID = -2032555716136454615L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_image_id")
	@JsonProperty("propertyImageId")
	private Long propertyImageId;

	@Column(name = "image_url")
	@JsonProperty("imageURL")
	private String imageURL;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "property_id", nullable = false)
	@JsonProperty("property")
	private PropertyEntity propertyEntity;
	
	@Override
	public String toString() {
		return Long.toString(propertyImageId);
	}
}
