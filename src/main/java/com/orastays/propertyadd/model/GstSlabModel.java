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
public class GstSlabModel extends CommonModel {

	@JsonProperty("gstSlabId")
	private Long gstSlabId;

	@JsonProperty("fromAmount")
	private String fromAmount;

	@JsonProperty("toAmount")
	private String toAmount;

	@JsonProperty("percentage")
	private String percentage;

}