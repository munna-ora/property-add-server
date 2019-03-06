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
public class CancellationSlabModel extends CommonModel {

	@JsonProperty("cancellationSlabId")
	private String cancellationSlabId;
	
	@JsonProperty("startTime")
	private String startTime;
	
	@JsonProperty("endTime")
	private String endTime;
	
	@JsonProperty("roomVsCancellations")
	private List<RoomVsCancellationModel> roomVsCancellationModels;
}
