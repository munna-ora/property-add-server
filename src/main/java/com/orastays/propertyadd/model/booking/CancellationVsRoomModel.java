package com.orastays.propertyadd.model.booking;

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
public class CancellationVsRoomModel extends CommonModel {

	@JsonProperty("cancellationVsRoomId")
	private Long cancellationVsRoomId;
	
	@JsonProperty("cancellationSlabId")
	private String cancellationSlabId;
	
	@JsonProperty("cancellations")
	private CancellationModel cancellationModel;
	
	@JsonProperty("bookingVsRooms")
	private BookingVsRoomModel bookingVsRoomModel;
	
}
