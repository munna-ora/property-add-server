package com.orastays.propertyadd.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "room_vs_meal")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class RoomVsMealEntity extends CommonEntity {

	private static final long serialVersionUID = -8324710712961275540L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_vs_meal_id")
	@JsonProperty("roomVsMealId")
	private Long roomVsMealId;

	@Column(name = "meal_type_sunday")
	@JsonProperty("mealTypeSunday")
	private String mealTypeSunday;

	@Column(name = "meal_type_monday")
	@JsonProperty("mealTypeMonday")
	private String mealTypeMonday;

	@Column(name = "meal_type_tuesday")
	@JsonProperty("mealTypeTuesday")
	private String mealTypeTuesday;

	@Column(name = "meal_type_wednesday")
	@JsonProperty("mealTypeWednesday")
	private String mealTypeWednesday;

	@Column(name = "meal_type_thursday")
	@JsonProperty("mealTypeThursday")
	private String mealTypeThursday;

	@Column(name = "meal_type_friday")
	@JsonProperty("mealTypeFriday")
	private String mealTypeFriday;

	@Column(name = "meal_type_saturday")
	@JsonProperty("mealTypeSaturday")
	private String mealTypeSaturday;

	@Column(name = "meal_days_sunday")
	@JsonProperty("mealDaysSunday")
	private String mealDaysSunday;

	@Column(name = "meal_days_monday")
	@JsonProperty("mealDaysMonday")
	private String mealDaysMonday;

	@Column(name = "meal_days_tuesday")
	@JsonProperty("mealDaysTuesday")
	private String mealDaysTuesday;

	@Column(name = "meal_days_wednesday")
	@JsonProperty("mealDaysWednesday")
	private String mealDaysWednesday;

	@Column(name = "meal_days_thursday")
	@JsonProperty("mealDaysThursday")
	private String mealDaysThursday;

	@Column(name = "meal_days_friday")
	@JsonProperty("mealDaysFriday")
	private String mealDaysFriday;

	@Column(name = "meal_days_saturday")
	@JsonProperty("mealDaysSaturday")
	private String mealDaysSaturday;

	@Column(name = "meal_price_category_sunday")
	@JsonProperty("mealPriceCategorySunday")
	private String mealPriceCategorySunday;

	@Column(name = "meal_price_category_monday")
	@JsonProperty("mealPriceCategoryMonday")
	private String mealPriceCategoryMonday;

	@Column(name = "meal_price_category_tuesday")
	@JsonProperty("mealPriceCategoryTuesday")
	private String mealPriceCategoryTuesday;

	@Column(name = "meal_price_category_wednesday")
	@JsonProperty("mealPriceCategoryWednesday")
	private String mealPriceCategoryWednesday;

	@Column(name = "meal_price_category_thursday")
	@JsonProperty("mealPriceCategoryThursday")
	private String mealPriceCategoryThursday;

	@Column(name = "meal_price_category_friday")
	@JsonProperty("mealPriceCategoryFriday")
	private String mealPriceCategoryFriday;

	@Column(name = "meal_price_category_saturday")
	@JsonProperty("mealPriceCategorySaturday")
	private String mealPriceCategorySaturday;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "room_id", nullable = false)
	@JsonProperty("room")
	private RoomEntity roomEntity;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn(name = "meal_plan_id", nullable = false)
	@JsonProperty("mealPlan")
	private MealPlanEntity mealPlanEntity;

	@Override
	public String toString() {
		return Long.toString(roomVsMealId);
	}
}
