package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.MealPlanCategoryEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.MealPlanCategoryModel;

@Component
public class MealPlanCategoryConverter extends CommonConverter
		implements BaseConverter<MealPlanCategoryEntity, MealPlanCategoryModel> {

	private static final long serialVersionUID = 5711677835864341929L;
	private static final Logger logger = LogManager.getLogger(MealPlanCategoryConverter.class);

	@Override
	public MealPlanCategoryEntity modelToEntity(MealPlanCategoryModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MealPlanCategoryModel entityToModel(MealPlanCategoryEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		MealPlanCategoryModel mealPlanCategoryModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			
			mealPlanCategoryModel = new MealPlanCategoryModel();
			mealPlanCategoryModel = (MealPlanCategoryModel) Util.transform(modelMapper, e, mealPlanCategoryModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return mealPlanCategoryModel;
	}

	@Override
	public List<MealPlanCategoryModel> entityListToModelList(List<MealPlanCategoryEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<MealPlanCategoryModel> mealPlanCategoryModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			mealPlanCategoryModels = new ArrayList<>();
			for(MealPlanCategoryEntity mealPlanCategoryEntity:es) {
				mealPlanCategoryModels.add(entityToModel(mealPlanCategoryEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return mealPlanCategoryModels;
	}

}
