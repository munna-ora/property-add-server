package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.PropertyVsImageEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.PropertyVsImageModel;

@Component
public class PropertyVsImageConverter extends CommonConverter
		implements BaseConverter<PropertyVsImageEntity, PropertyVsImageModel> {

	private static final long serialVersionUID = -67953202535609461L;
	private static final Logger logger = LogManager.getLogger(PropertyVsImageConverter.class);

	@Override
	public PropertyVsImageEntity modelToEntity(PropertyVsImageModel m) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyVsImageEntity propertyVsImageEntity = new PropertyVsImageEntity();
		propertyVsImageEntity = (PropertyVsImageEntity) Util.transform(modelMapper, m, propertyVsImageEntity);
		propertyVsImageEntity.setStatus(Status.ACTIVE.ordinal());
		propertyVsImageEntity.setCreatedDate(Util.getCurrentDateTime());
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyVsImageEntity;
	}

	@Override
	public PropertyVsImageModel entityToModel(PropertyVsImageEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyVsImageModel propertyVsImageModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			propertyVsImageModel = new PropertyVsImageModel();
			propertyVsImageModel = (PropertyVsImageModel) Util.transform(modelMapper, e, propertyVsImageModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyVsImageModel;
	}

	@Override
	public List<PropertyVsImageModel> entityListToModelList(List<PropertyVsImageEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<PropertyVsImageModel> propertyVsImageModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			propertyVsImageModels = new ArrayList<>();
			for(PropertyVsImageEntity propertyVsImageEntity:es) {
				propertyVsImageModels.add(entityToModel(propertyVsImageEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return propertyVsImageModels;
	}

}
