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
public class PriceDropModel extends CommonModel {

	@JsonProperty("priceDropId")
	private String priceDropId;
	
	@JsonProperty("afterTime")
	private String afterTime;
	
	@JsonProperty("propertyVsPriceDrops")
	private List<PropertyVsPriceDropModel> propertyVsPriceDropModels;
}
