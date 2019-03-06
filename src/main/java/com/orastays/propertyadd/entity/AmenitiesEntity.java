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
@Table(name = "master_amenities")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AmenitiesEntity extends CommonEntity {

	private static final long serialVersionUID = 5562924720677171528L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aminities_id")
	@JsonProperty("aminitiesId")
	private Long aminitiesId;

	@Column(name = "aminities_name")
	@JsonProperty("aminitiesName")
	private String aminitiesName;

	@Column(name = "filter_flag")
	@JsonProperty("filterFlag")
	private String filterFlag;

	@Column(name = "priority")
	@JsonProperty("priority")
	private String priority;

	@Column(name = "express_flag")
	@JsonProperty("expressFlag")
	private String expressFlag;

	@Column(name = "premium_flag")
	@JsonProperty("premiumFlag")
	private String premiumFlag;

	@Column(name = "aminities_type")
	@JsonProperty("aminitiesType")
	private String aminitiesType;

	@Column(name = "language_id")
	@JsonProperty("languageId")
	private Long languageId;

	@Column(name = "parent_id")
	@JsonProperty("parentId")
	private Long parentId;

	@Column(name = "img_url1")
	@JsonProperty("imgUrl1")
	private String imgUrl1;

	@Column(name = "img_url2")
	@JsonProperty("imgUrl2")
	private String imgUrl2;
	
	@Column(name = "smimg_url")
	@JsonProperty("smImgUrl")
	private String smImgUrl;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "amenitiesEntity", cascade = { CascadeType.ALL })
	@JsonProperty("roomVsAmenities")
	private List<RoomVsAmenitiesEntity> roomVsAmenitiesEntities;

	@Override
	public String toString() {
		return Long.toString(aminitiesId);
	}
}