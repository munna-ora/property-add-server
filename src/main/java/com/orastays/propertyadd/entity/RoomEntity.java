package com.orastays.propertyadd.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_room")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomEntity extends CommonEntity {

	private static final long serialVersionUID = 6058717921502574720L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	@JsonProperty("roomId")
	private Long roomId;
	
	@Column(name = "ora_room_name")
	@JsonProperty("oraRoomName")
	private String oraRoomName;

	@Column(name = "shared_space")
	@JsonProperty("sharedSpace")
	private String sharedSpace;

	@Column(name = "cot_available")
	@JsonProperty("cotAvailable")
	private String cotAvailable;

	@Column(name = "no_of_guest")
	@JsonProperty("noOfGuest")
	private String noOfGuest;

	@Column(name = "no_of_child")
	@JsonProperty("noOfChild")
	private String noOfChild;

	@Column(name = "num_of_cot")
	@JsonProperty("numOfCot")
	private String numOfCot;

	@Column(name = "room_current_status")
	@JsonProperty("roomCurrentStatus")
	private String roomCurrentStatus;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "room_cat_id", nullable = false)
	@JsonProperty("roomCategory")
	private RoomCategoryEntity roomCategoryEntity;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "property_id", nullable = false)
	@JsonProperty("property")
	private PropertyEntity propertyEntity;

	@Column(name = "room_price_per_night")
	@JsonProperty("roomPricePerNight")
	private String roomPricePerNight;

	@Column(name = "room_price_per_month")
	@JsonProperty("roomPricePerMonth")
	private String roomPricePerMonth;

	@Column(name = "shared_bed_price_per_night")
	@JsonProperty("sharedBedPricePerNight")
	private String sharedBedPricePerNight;

	@Column(name = "shared_bed_price_per_month")
	@JsonProperty("sharedBedPricePerMonth")
	private String sharedBedPricePerMonth;

	@Column(name = "cot_price")
	@JsonProperty("cotPrice")
	private String cotPrice;

	@Column(name = "shared_bed_price")
	@JsonProperty("sharedBedPrice")
	private String sharedBedPrice;

	@Column(name = "commission")
	@JsonProperty("commission")
	private String commission;

	@Column(name = "ora_percentage")
	@JsonProperty("oraPercentage")
	private String oraPercentage;

	@Column(name = "host_discount_weekly")
	@JsonProperty("hostDiscountWeekly")
	private String hostDiscountWeekly;

	@Column(name = "host_discount_monthly")
	@JsonProperty("hostDiscountMonthly")
	private String hostDiscountMonthly;
	
	@Column(name = "ora_discount_percentage")
	@JsonProperty("oraDiscountPercentage")
	private String oraDiscountPercentage;
	
	@Column(name = "accomodation_name")
	@JsonProperty("accommodationName")
	private String accommodationName;
	
	@Column(name = "room_standard")
	@JsonProperty("roomStandard")
	private String roomStandard;
	
	@Column(name = "num_of_bed")
	@JsonProperty("numOfBed")
	private String numOfBed;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomEntity", cascade = { CascadeType.ALL })
	@JsonProperty("roomVsAmenities")
	private List<RoomVsAmenitiesEntity> roomVsAmenitiesEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomEntity", cascade = { CascadeType.ALL })
	@JsonProperty("roomVsCancellations")
	private List<RoomVsCancellationEntity> roomVsCancellationEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomEntity", cascade = { CascadeType.ALL })
	@JsonProperty("roomVsImages")
	private List<RoomVsImageEntity> roomVsImageEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomEntity", cascade = { CascadeType.ALL })
	@JsonProperty("roomVsSpecialities")
	private List<RoomVsSpecialitiesEntity> roomVsSpecialitiesEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomEntity", cascade = { CascadeType.ALL })
	@JsonProperty("roomVsMeals")
	private List<RoomVsMealEntity> roomVsMealEntities;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomEntity", cascade = { CascadeType.ALL })
	@JsonProperty("roomVsOffers")
	private List<RoomVsOfferEntity> roomVsOfferEntities;

	@Override
	public String toString() {
		return Long.toString(roomId);
	}
}
