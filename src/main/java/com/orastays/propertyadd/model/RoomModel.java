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
public class RoomModel extends CommonModel {

	@JsonProperty("roomId")
	private String roomId;
	
	@JsonProperty("oraRoomName")
	private String oraRoomName;

	@JsonProperty("sharedSpace")
	private String sharedSpace;

	@JsonProperty("cotAvailable")
	private String cotAvailable;

	@JsonProperty("noOfGuest")
	private String noOfGuest;

	@JsonProperty("noOfChild")
	private String noOfChild;

	@JsonProperty("numOfCot")
	private String numOfCot;

	@JsonProperty("roomCurrentStatus")
	private String roomCurrentStatus;

	@JsonProperty("roomCategory")
	private RoomCategoryModel roomCategoryModel;

	@JsonProperty("property")
	private PropertyModel propertyModel;

	@JsonProperty("roomPricePerNight")
	private String roomPricePerNight;

	@JsonProperty("roomPricePerMonth")
	private String roomPricePerMonth;

	@JsonProperty("sharedBedPricePerNight")
	private String sharedBedPricePerNight;

	@JsonProperty("sharedBedPricePerMonth")
	private String sharedBedPricePerMonth;

	@JsonProperty("cotPrice")
	private String cotPrice;

	@JsonProperty("sharedBedPrice")
	private String sharedBedPrice;

	@JsonProperty("commission")
	private String commission;

	@JsonProperty("oraPercentage")
	private String oraPercentage;

	@JsonProperty("hostDiscountWeekly")
	private String hostDiscountWeekly;

	@JsonProperty("hostDiscountMonthly")
	private String hostDiscountMonthly;
	
	@JsonProperty("oraDiscountPercentage")
	private String oraDiscountPercentage;
	
	@JsonProperty("accommodationName")
	private String accommodationName;
	
	@JsonProperty("roomStandard")
	private String roomStandard;
	
	@JsonProperty("numOfBed")
	private String numOfBed;

	@JsonProperty("roomVsAmenities")
	private List<RoomVsAmenitiesModel> roomVsAmenitiesModels;

	@JsonProperty("roomVsCancellations")
	private List<RoomVsCancellationModel> roomVsCancellationModels;

	@JsonProperty("roomVsImages")
	private List<RoomVsImageModel> roomVsImageModels;

	@JsonProperty("roomVsSpecialities")
	private List<RoomVsSpecialitiesModel> roomVsSpecialitiesModels;

	@JsonProperty("roomVsMeals")
	private List<RoomVsMealModel> roomVsMealModels;
	
	@JsonProperty("roomVsOffers")
	private List<RoomVsOfferModel> roomVsOfferModels;

}
