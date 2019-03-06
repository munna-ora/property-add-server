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
@Table(name = "master_meal_plan")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MealPlanEntity extends CommonEntity {

	private static final long serialVersionUID = 3365288762964751801L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "meal_plan_id")
	@JsonProperty("mealPlanId")
	private Long mealPlanId;

	@Column(name = "meal_plan_name")
	@JsonProperty("mealPlanName")
	private String mealPlanName;

	@Column(name = "language_id")
	@JsonProperty("languageId")
	private Long languageId;

	@Column(name = "parent_id")
	@JsonProperty("parentId")
	private Long parentId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mealPlanEntity", cascade = { CascadeType.ALL })
	@JsonProperty("mealPlanCatVsMealPlans")
	private List<MealPlanCatVsMealPlanEntity> mealPlanCatVsMealPlanEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mealPlanEntity", cascade = { CascadeType.ALL })
	@JsonProperty("roomVsMeals")
	private List<RoomVsMealEntity> roomVsMealEntities;

	@Override
	public String toString() {
		return Long.toString(mealPlanId);
	}
}