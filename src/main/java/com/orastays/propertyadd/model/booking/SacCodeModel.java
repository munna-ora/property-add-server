package com.orastays.propertyadd.model.booking;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orastays.propertyadd.model.CommonModel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class SacCodeModel extends CommonModel {
	
	@JsonProperty("sacCodeId")
	private String sacCodeId;
	@JsonProperty("sacName")
	private String sacName;
	@JsonProperty("sacCodeNumber")
	private String sacCodeNumber;
	@JsonProperty("bookingVsRooms")
	private List<BookingVsRoomModel> bookingVsRoomModels;

}
