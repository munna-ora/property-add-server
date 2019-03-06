package com.orastays.propertyadd.model;

import java.util.List;

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
public class StateModel extends CommonModel {

	@JsonProperty("stateId")
	private String stateId;

	@JsonProperty("stateName")
	private String stateName;
	
	@JsonProperty("countrys")
	private CountryModel countryModel;
	
	@JsonProperty("citys")
	private List<CityModel> cityModels;
}
