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
public class MealPlanCatVsMealPlanModel extends CommonModel {

	@JsonProperty("mpcmpId")
	private String mpcmpId;

	@JsonProperty("mealPlanCategory")
	private MealPlanCategoryModel mealPlanCategoryModel;

	@JsonProperty("mealPlan")
	private MealPlanModel mealPlanModel;
}
