package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.PropertyVsNearbyEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.PropertyVsNearbyModel;

@Component
public class PropertyVsNearbyConverter extends CommonConverter
		implements BaseConverter<PropertyVsNearbyEntity, PropertyVsNearbyModel> {

	private static final long serialVersionUID = -5052826047073738394L;
	private static final Logger logger = LogManager.getLogger(PropertyVsNearbyConverter.class);

	@Override
	public PropertyVsNearbyEntity modelToEntity(PropertyVsNearbyModel m) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyVsNearbyEntity propertyVsNearbyEntity = new PropertyVsNearbyEntity();
		propertyVsNearbyEntity = (PropertyVsNearbyEntity) Util.transform(modelMapper, m, propertyVsNearbyEntity);
		propertyVsNearbyEntity.setStatus(Status.ACTIVE.ordinal());
		propertyVsNearbyEntity.setCreatedDate(Util.getCurrentDateTime());
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyVsNearbyEntity;
	}

	@Override
	public PropertyVsNearbyModel entityToModel(PropertyVsNearbyEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyVsNearbyModel propertyVsNearbyModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			propertyVsNearbyModel = new PropertyVsNearbyModel();
			propertyVsNearbyModel = (PropertyVsNearbyModel) Util.transform(modelMapper, e, propertyVsNearbyModel);
		}
		
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyVsNearbyModel;
	}

	@Override
	public List<PropertyVsNearbyModel> entityListToModelList(List<PropertyVsNearbyEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<PropertyVsNearbyModel> propertyVsNearbyModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			propertyVsNearbyModels = new ArrayList<>();
			for(PropertyVsNearbyEntity propertyVsNearbyEntity:es) {
				propertyVsNearbyModels.add(entityToModel(propertyVsNearbyEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return propertyVsNearbyModels;
	}

}
