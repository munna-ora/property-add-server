package com.orastays.propertyadd.model;

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
public class RoomVsAmenitiesModel extends CommonModel {

	@JsonProperty("roomVsAminitiesId")
	private String roomVsAminitiesId;
	
	@JsonProperty("amenities")
	private AmenitiesModel amenitiesModel;
	
	@JsonProperty("room")
	private RoomModel roomModel;
}
