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
public class MealPlanModel extends CommonModel {

	@JsonProperty("mealPlanId")
	private String mealPlanId;

	@JsonProperty("mealPlanName")
	private String mealPlanName;

	@JsonProperty("languageId")
	private String languageId;

	@JsonProperty("parentId")
	private String parentId;

	@JsonProperty("mealPlanCatVsMealPlans")
	private List<MealPlanCatVsMealPlanModel> mealPlanCatVsMealPlanModels;

	@JsonProperty("roomVsMeals")
	private List<RoomVsMealModel> roomVsMealModels;
}
