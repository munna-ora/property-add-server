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
@Table(name = "master_special_experience")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SpecialExperienceEntity extends CommonEntity {

	private static final long serialVersionUID = 8930860447409208950L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_id")
	@JsonProperty("experienceId")
	private Long experienceId;

	@Column(name = "language_id")
	@JsonProperty("languageId")
	private Long languageId;

	@Column(name = "parent_id")
	@JsonProperty("parentId")
	private Long parentId;

	@Column(name = "experience_name")
	@JsonProperty("experienceName")
	private String experienceName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialExperienceEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertyVsSpecialExperiences")
	private List<PropertyVsSpecialExperienceEntity> propertyVsSpecialExperienceEntities;


	@Override
	public String toString() {
		return Long.toString(experienceId);
	}
}
