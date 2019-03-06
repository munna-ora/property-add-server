package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.PropertyVsDescriptionEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.PropertyVsDescriptionModel;

@Component
public class PropertyVsDescriptionConverter extends CommonConverter
		implements BaseConverter<PropertyVsDescriptionEntity, PropertyVsDescriptionModel> {

	private static final long serialVersionUID = 450326924626216300L;
	private static final Logger logger = LogManager.getLogger(PropertyVsDescriptionConverter.class);

	@Override
	public PropertyVsDescriptionEntity modelToEntity(PropertyVsDescriptionModel m) {
		
		PropertyVsDescriptionEntity propertyVsDescriptionEntity = new PropertyVsDescriptionEntity();
		propertyVsDescriptionEntity = (PropertyVsDescriptionEntity) Util.transform(modelMapper, m, propertyVsDescriptionEntity);
		propertyVsDescriptionEntity.setStatus(Status.ACTIVE.ordinal());
		propertyVsDescriptionEntity.setCreatedDate(Util.getCurrentDateTime());
		return propertyVsDescriptionEntity;
	}

	@Override
	public PropertyVsDescriptionModel entityToModel(PropertyVsDescriptionEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyVsDescriptionModel propertyVsDescriptionModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()){
			propertyVsDescriptionModel = new PropertyVsDescriptionModel();
			propertyVsDescriptionModel = (PropertyVsDescriptionModel) Util.transform(modelMapper, e, propertyVsDescriptionModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyVsDescriptionModel;
	}

	@Override
	public List<PropertyVsDescriptionModel> entityListToModelList(List<PropertyVsDescriptionEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<PropertyVsDescriptionModel> propertyVsDescriptionModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			propertyVsDescriptionModels = new ArrayList<>();
			for(PropertyVsDescriptionEntity propertyVsDescriptionEntity:es) {
				propertyVsDescriptionModels.add(entityToModel(propertyVsDescriptionEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return propertyVsDescriptionModels;
	}
	
}
