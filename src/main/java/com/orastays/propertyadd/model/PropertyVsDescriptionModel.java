package com.orastays.propertyadd.model;

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
public class PropertyVsDescriptionModel extends CommonModel {

	@JsonProperty("propertyDescId")
	private String propertyDescId;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("languageId")
	private String languageId;
	
	@JsonProperty("property")
	private PropertyModel propertyModel;
}
