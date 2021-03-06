package com.orastays.propertyadd.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class SpecialExperienceModel extends CommonModel {

	@JsonProperty("experienceId")
	private String experienceId;

	@JsonProperty("languageId")
	private String languageId;

	@JsonProperty("parentId")
	private String parentId;

	@JsonProperty("experienceName")
	private String experienceName;

	@JsonProperty("propertyVsSpecialExperiences")
	private List<PropertyVsSpecialExperienceModel> propertyVsSpecialExperienceModels;
}
