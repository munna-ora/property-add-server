package com.orastays.propertyadd.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class StayTypeModel extends CommonModel {

	@JsonProperty("stayTypeId")
	private String stayTypeId;

	@JsonProperty("languageId")
	private String languageId;

	@JsonProperty("parentId")
	private String parentId;

	@JsonProperty("stayTypeName")
	private String stayTypeName;

	@JsonProperty("property")
	private PropertyModel propertyModel;
}
