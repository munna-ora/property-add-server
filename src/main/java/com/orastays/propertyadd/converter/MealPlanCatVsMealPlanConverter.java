package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.MealPlanCatVsMealPlanEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.MealPlanCatVsMealPlanModel;

@Component
public class MealPlanCatVsMealPlanConverter extends CommonConverter
		implements BaseConverter<MealPlanCatVsMealPlanEntity, MealPlanCatVsMealPlanModel> {

	private static final long serialVersionUID = 5446873681124249282L;
	private static final Logger logger = LogManager.getLogger(MealPlanCatVsMealPlanConverter.class);

	@Override
	public MealPlanCatVsMealPlanEntity modelToEntity(MealPlanCatVsMealPlanModel m) {
		return null;
	}

	@Override
	public MealPlanCatVsMealPlanModel entityToModel(MealPlanCatVsMealPlanEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		MealPlanCatVsMealPlanModel mealPlanCategoryVsMealPlanModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			
			mealPlanCategoryVsMealPlanModel = new MealPlanCatVsMealPlanModel();
			mealPlanCategoryVsMealPlanModel = (MealPlanCatVsMealPlanModel) Util.transform(modelMapper, e, mealPlanCategoryVsMealPlanModel);
			mealPlanCategoryVsMealPlanModel.setMealPlanCategoryModel(mealPlanCategoryConverter.entityToModel(e.getMealPlanCategoryEntity()));
			mealPlanCategoryVsMealPlanModel.setMealPlanModel(mealPlanConverter.entityToModel(e.getMealPlanEntity()));
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return mealPlanCategoryVsMealPlanModel;
	}

	@Override
	public List<MealPlanCatVsMealPlanModel> entityListToModelList(List<MealPlanCatVsMealPlanEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<MealPlanCatVsMealPlanModel> mealPlanCategoryVsMealPlanModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			mealPlanCategoryVsMealPlanModels = new ArrayList<>();
			for(MealPlanCatVsMealPlanEntity mealPlanCatVsMealPlanEntity:es) {
				mealPlanCategoryVsMealPlanModels.add(entityToModel(mealPlanCatVsMealPlanEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return mealPlanCategoryVsMealPlanModels;
	}

}
