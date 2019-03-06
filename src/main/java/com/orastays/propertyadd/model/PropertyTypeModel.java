package com.orastays.propertyadd.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@JsonInclude(Include.NON_NULL)
public class PropertyTypeModel extends CommonModel {

	@JsonProperty("propertyTypeId")
	private String propertyTypeId;
	
	@JsonProperty("languageId")
	private String languageId;
	
	@JsonProperty("parentId")
	private String parentId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("imgUrl")
	private String imgUrl;
	
	@JsonProperty("property")
	private List<PropertyModel> propertyModels;
	
	@JsonProperty("roomCategory")
	private List<RoomCategoryModel> roomCategoryModels;
}
