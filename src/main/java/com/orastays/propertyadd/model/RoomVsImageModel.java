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
public class RoomVsImageModel extends CommonModel {

	@JsonProperty("roomVsImageId")
	private String roomVsImageId;
	
	@JsonProperty("imageUrl")
	private String imageUrl;
	
	@JsonProperty("room")
	private RoomModel roomModel;
}
