package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.PropertyVsToiletryEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.PropertyVsToiletryModel;

@Component
public class PropertyVsToiletryConverter extends CommonConverter
		implements BaseConverter<PropertyVsToiletryEntity, PropertyVsToiletryModel> {

	private static final long serialVersionUID = 8093738387798313320L;
	private static final Logger logger = LogManager.getLogger(PropertyVsToiletryConverter.class);

	@Override
	public PropertyVsToiletryEntity modelToEntity(PropertyVsToiletryModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyVsToiletryModel entityToModel(PropertyVsToiletryEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyVsToiletryModel propertyVsToiletryModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()){
			propertyVsToiletryModel = new PropertyVsToiletryModel();
			propertyVsToiletryModel = (PropertyVsToiletryModel) Util.transform(modelMapper, e, propertyVsToiletryModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyVsToiletryModel;
	}

	@Override
	public List<PropertyVsToiletryModel> entityListToModelList(List<PropertyVsToiletryEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<PropertyVsToiletryModel> propertyVsToiletryModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			propertyVsToiletryModels = new ArrayList<>();
			for(PropertyVsToiletryEntity propertyVsToiletryEntity:es) {
				propertyVsToiletryModels.add(entityToModel(propertyVsToiletryEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return propertyVsToiletryModels;
	}

}
