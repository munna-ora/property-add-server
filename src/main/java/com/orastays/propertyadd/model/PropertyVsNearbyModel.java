package com.orastays.propertyadd.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class PropertyVsNearbyModel extends CommonModel {

	@JsonProperty("propertyNearbyId")
	private String propertyNearbyId;
	
	@JsonProperty("places")
	private String places;
	
	@JsonProperty("latitude")
	private String latitude;
	
	@JsonProperty("longitude")
	private String longitude;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("property")
	private PropertyModel propertyModel;
}
