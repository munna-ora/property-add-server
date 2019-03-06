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
public class ConvenienceModel extends CommonModel {

	@JsonProperty("convenienceId")
	private Long convenienceId;

	@JsonProperty("amount")
	private String amount;
	
	@JsonProperty("gstPercentage")
	private String gstPercentage;
}