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
public class CountryModel extends CommonModel {

	@JsonProperty("countryId")
	private String countryId;

	@JsonProperty("countryCode")
	private String countryCode;
	
	@JsonProperty("countryName")
	private String countryName;
	
	@JsonProperty("states")
	private List<StateModel> stateModels;
	
}
