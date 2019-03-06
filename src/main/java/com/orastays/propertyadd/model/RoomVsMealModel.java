package com.orastays.propertyadd.model;

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
public class RoomVsMealModel extends CommonModel {

	@JsonProperty("roomVsMealId")
	private String roomVsMealId;

	@JsonProperty("mealTypeSunday")
	private String mealTypeSunday;

	@JsonProperty("mealTypeMonday")
	private String mealTypeMonday;

	@JsonProperty("mealTypeTuesday")
	private String mealTypeTuesday;

	@JsonProperty("mealTypeWednesday")
	private String mealTypeWednesday;

	@JsonProperty("mealTypeThursday")
	private String mealTypeThursday;

	@JsonProperty("mealTypeFriday")
	private String mealTypeFriday;

	@JsonProperty("mealTypeSaturday")
	private String mealTypeSaturday;

	@JsonProperty("mealDaysSunday")
	private String mealDaysSunday;

	@JsonProperty("mealDaysMonday")
	private String mealDaysMonday;

	@JsonProperty("mealDaysTuesday")
	private String mealDaysTuesday;

	@JsonProperty("mealDaysWednesday")
	private String mealDaysWednesday;

	@JsonProperty("mealDaysThursday")
	private String mealDaysThursday;

	@JsonProperty("mealDaysFriday")
	private String mealDaysFriday;

	@JsonProperty("mealDaysSaturday")
	private String mealDaysSaturday;

	@JsonProperty("mealPriceCategorySunday")
	private String mealPriceCategorySunday;

	@JsonProperty("mealPriceCategoryMonday")
	private String mealPriceCategoryMonday;

	@JsonProperty("mealPriceCategoryTuesday")
	private String mealPriceCategoryTuesday;

	@JsonProperty("mealPriceCategoryWednesday")
	private String mealPriceCategoryWednesday;

	@JsonProperty("mealPriceCategoryThursday")
	private String mealPriceCategoryThursday;

	@JsonProperty("mealPriceCategoryFriday")
	private String mealPriceCategoryFriday;

	@JsonProperty("mealPriceCategorySaturday")
	private String mealPriceCategorySaturday;

	@JsonProperty("room")
	private RoomModel roomModel;

	@JsonProperty("mealPlan")
	private MealPlanModel mealPlanModel;
}
