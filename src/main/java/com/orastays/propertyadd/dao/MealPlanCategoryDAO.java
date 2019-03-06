package com.orastays.propertyadd.dao;

import org.springframework.stereotype.Repository;

import com.orastays.propertyadd.entity.MealPlanCategoryEntity;

@Repository
public class MealPlanCategoryDAO extends GenericDAO<MealPlanCategoryEntity, Long>{

	private static final long serialVersionUID = 2378674047575583918L;

	public MealPlanCategoryDAO() {
		super(MealPlanCategoryEntity.class);
	}
}
