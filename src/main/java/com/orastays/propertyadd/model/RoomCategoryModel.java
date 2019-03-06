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
public class RoomCategoryModel extends CommonModel {

	@JsonProperty("roomCatId")
	private String roomCatId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("languageId")
	private String languageId;
	
	@JsonProperty("parentId")
	private String parentId;
	
	@JsonProperty("rooms")
	private List<RoomModel> roomModels;
	
	@JsonProperty("propertyType")
	private PropertyTypeModel propertyTypeModel;
}
