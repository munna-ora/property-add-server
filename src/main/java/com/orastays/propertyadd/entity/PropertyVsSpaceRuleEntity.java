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
@Table(name = "property_vs_space")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PropertyVsSpaceRuleEntity extends CommonEntity  {
	
	private static final long serialVersionUID = -8120697720759971508L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_space_id")
	@JsonProperty("propertySpaceId")
	private Long propertySpaceId;
	
	@Column(name = "answer")
	@JsonProperty("answer")
	private String answer;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "sprule_id", nullable = false)
	@JsonProperty("spaceRule")
	private SpaceRuleEntity spaceRuleEntity;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "property_id", nullable = false)
	@JsonProperty("property")
	private PropertyEntity propertyEntity;
	
	@Override
	public String toString() {
		return Long.toString(propertySpaceId);
	}
}
