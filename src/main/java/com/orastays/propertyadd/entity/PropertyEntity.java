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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_property")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PropertyEntity extends CommonEntity {

	private static final long serialVersionUID = -7666760673115186373L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_id")
	@JsonProperty("propertyId")
	private Long propertyId;

	@Column(name = "name")
	@JsonProperty("name")
	private String name;

	@Column(name = "oraname")
	@JsonProperty("oraname")
	private String oraname;

	@Column(name = "entire_apartment")
	@JsonProperty("entireApartment")
	private String entireApartment;

	@Column(name = "sex_category")
	@JsonProperty("sexCategory")
	private String sexCategory;

	@Column(name = "apartment_name")
	@JsonProperty("apartmentName")
	private String apartmentName;

	@Column(name = "apartment_number")
	@JsonProperty("apartmentNumber")
	private String apartmentNumber;

	@Column(name = "latitude")
	@JsonProperty("latitude")
	private String latitude;

	@Column(name = "longitude")
	@JsonProperty("longitude")
	private String longitude;

	@Column(name = "address", length = 65535, columnDefinition = "Text")
	@JsonProperty("address")
	private String address;

	@Column(name = "start_date")
	@JsonProperty("startDate")
	private String startDate;

	@Column(name = "end_date")
	@JsonProperty("endDate")
	private String endDate;

	@Column(name = "checkin_time")
	@JsonProperty("checkinTime")
	private String checkinTime;

	@Column(name = "checkout_time")
	@JsonProperty("checkoutTime")
	private String checkoutTime;

	@Column(name = "cover_image_url")
	@JsonProperty("coverImageUrl")
	private String coverImageUrl;

	@Column(name = "price_drop")
	@JsonProperty("priceDrop")
	private String priceDrop;

	@Column(name = "immediate_booking")
	@JsonProperty("immediateBooking")
	private String immediateBooking;

	@Column(name = "strict_checkin")
	@JsonProperty("strictCheckin")
	private String strictCheckin;

	@Column(name = "contact_name")
	@JsonProperty("contactName")
	private String contactName;

	@Column(name = "alt_mobile")
	@JsonProperty("altMobile")
	private String altMobile;

	@Column(name = "alt_email")
	@JsonProperty("altEmail")
	private String altEmail;

	@Column(name = "landline")
	@JsonProperty("landline")
	private String landline;

	@Column(name = "advance_percentage")
	@JsonProperty("advancePercentage")
	private String advancePercentage;

	@Column(name = "location")
	@JsonProperty("location")
	private String location;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "property_type_id", nullable = false)
	@JsonProperty("propertyType")
	private PropertyTypeEntity propertyTypeEntity;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "city_id", nullable = false)
	@JsonProperty("city")
	private CityEntity cityEntity;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "stay_type_id", nullable = false)
	@JsonProperty("stayType")
	private StayTypeEntity stayTypeEntity;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "host_vs_account_id", nullable = false)
	@JsonProperty("hostVsAccount")
	private HostVsAccountEntity hostVsAccountEntity;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertyVsDocuments")
	private List<PropertyVsDocumentEntity> propertyVsDocumentEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertyVsDescriptions")
	private List<PropertyVsDescriptionEntity> propertyVsDescriptionEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertyVsGuestAccess")
	private List<PropertyVsGuestAccessEntity> propertyVsGuestAccessEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertyVsImages")
	private List<PropertyVsImageEntity> propertyVsImageEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertyVsNearbys")
	private List<PropertyVsNearbyEntity> propertyVsNearbyEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertyVsPriceDrops")
	private List<PropertyVsPriceDropEntity> propertyVsPriceDropEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertyVsSpaceRules")
	private List<PropertyVsSpaceRuleEntity> propertyVsSpaceRuleEntities;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertyVsToiletrys")
	private PropertyVsToiletryEntity propertyVsToiletryEntity;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = { CascadeType.ALL })
	@JsonProperty("propertyVsSpecialExperiences")
	private List<PropertyVsSpecialExperienceEntity> propertyVsSpecialExperienceEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyEntity", cascade = { CascadeType.ALL })
	@JsonProperty("rooms")
	private List<RoomEntity> roomEntities;

	@Override
	public String toString() {
		return Long.toString(propertyId);
	}

}
