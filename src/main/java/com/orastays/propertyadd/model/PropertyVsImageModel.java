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
public class PropertyVsImageModel extends CommonModel {

	@JsonProperty("propertyImageId")
	private String propertyImageId;
	
	@JsonProperty("imageURL")
	private String imageURL;
	
	@JsonProperty("property")
	private PropertyModel propertyModel;
}
