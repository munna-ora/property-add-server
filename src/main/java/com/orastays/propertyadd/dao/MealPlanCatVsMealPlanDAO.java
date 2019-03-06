package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.MealPlanCatVsMealPlanEntity;

@Repository
public class MealPlanCatVsMealPlanDAO extends GenericDAO<MealPlanCatVsMealPlanEntity, Long>{

	private static final long serialVersionUID = -6695047045835656623L;

	public MealPlanCatVsMealPlanDAO() {
		super(MealPlanCatVsMealPlanEntity.class);
	}
}
