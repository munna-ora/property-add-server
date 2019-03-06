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
@Table(name = "property_vs_description")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PropertyVsDescriptionEntity extends CommonEntity  {
	
	private static final long serialVersionUID = 7334573917152398666L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_desc_id")
	@JsonProperty("propertyDescId")
	private Long propertyDescId;

	@Column(name = "description", length = 65535,columnDefinition="Text")
	@JsonProperty("description")
	private String description;
	
	@Column(name = "language_id")
	@JsonProperty("languageId")
	private Long languageId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "property_id", nullable = false)
	@JsonProperty("property")
	private PropertyEntity propertyEntity;
	
	@Override
	public String toString() {
		return Long.toString(propertyDescId);
	}
}
