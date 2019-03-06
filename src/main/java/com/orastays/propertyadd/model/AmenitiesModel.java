package com.orastays.propertyadd.model;

import java.util.Comparator;
import java.util.List;

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
public class AmenitiesModel extends CommonModel implements Comparator<AmenitiesModel> {

	@JsonProperty("aminitiesId")
	private String aminitiesId;

	@JsonProperty("aminitiesName")
	private String aminitiesName;

	@JsonProperty("filterFlag")
	private String filterFlag;

	@JsonProperty("priority")
	private String priority;

	@JsonProperty("expressFlag")
	private String expressFlag;

	@JsonProperty("premiumFlag")
	private String premiumFlag;
	
	@JsonProperty("imgUrl1")
	private String imgUrl1;
	
	@JsonProperty("imgUrl2")
	private String imgUrl2;

	@JsonProperty("aminitiesType")
	private String aminitiesType;
	
	@JsonProperty("smImgUrl")
	private String smImgUrl;

	@JsonProperty("languageId")
	private String languageId;

	@JsonProperty("parentId")
	private String parentId;

	@JsonProperty("roomVsAmenities")
	private List<RoomVsAmenitiesModel> roomVsAmenitiesModels;

	@Override
	public int compare(AmenitiesModel arg0, AmenitiesModel arg1) {
		
		return arg0.getPriority().compareTo(arg1.getPriority());
	}
}
