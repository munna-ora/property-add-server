package com.orastays.propertyadd.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "master_offer")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class OfferEntity extends CommonEntity {

	private static final long serialVersionUID = 8886227034363645595L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "offer_id")
	@JsonProperty("offerId")
	private Long offerId;

	@Column(name = "offer_name")
	@JsonProperty("offerName")
	private String offerName;

	@Column(name = "percentage")
	@JsonProperty("percentage")
	private String percentage;

	@Column(name = "amount")
	@JsonProperty("amount")
	private String amount;

	@Column(name = "start_date_range")
	@JsonProperty("startDateRange")
	private String startDateRange;

	@Column(name = "end_date_range")
	@JsonProperty("endDateRange")
	private String endDateRange;

	@Column(name = "online")
	@JsonProperty("online")
	private String online;
	
	@Column(name = "offer_desc")
	@JsonProperty("offerDesc")
	private String offerDesc;

	@Column(name = "max_amount")
	@JsonProperty("maxAmount")
	private String maxAmount;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "offerEntity", cascade = { CascadeType.ALL })
	@JsonProperty("roomVsOffers")
	private List<RoomVsOfferEntity> roomVsOfferEntities;

	@Override
	public String toString() {
		return Long.toString(offerId);
	}

}
