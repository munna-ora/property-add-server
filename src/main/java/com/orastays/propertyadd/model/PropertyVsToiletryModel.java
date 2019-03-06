package com.orastays.propertyadd.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class PropertyVsToiletryModel extends CommonModel {

	@JsonProperty("propertyVsToiletryId")
	private Long propertyVsToiletryId;

	@JsonProperty("total")
	private String total;
	
	@JsonProperty("used")
	private String used;
	
	@JsonProperty("pending")
	private String pending;
	
	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("property")
	private PropertyModel propertyModel;
}
