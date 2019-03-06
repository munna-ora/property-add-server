package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.PropertyTypeEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.PropertyTypeModel;

@Component
public class PropertyTypeConverter extends CommonConverter
		implements BaseConverter<PropertyTypeEntity, PropertyTypeModel> {

	private static final long serialVersionUID = 7470863919139179518L;
	private static final Logger logger = LogManager.getLogger(PropertyTypeConverter.class);

	@Override
	public PropertyTypeEntity modelToEntity(PropertyTypeModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyTypeModel entityToModel(PropertyTypeEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyTypeModel propertyTypeModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()){
			propertyTypeModel = new PropertyTypeModel();
			propertyTypeModel = (PropertyTypeModel) Util.transform(modelMapper, e, propertyTypeModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyTypeModel;
	}

	@Override
	public List<PropertyTypeModel> entityListToModelList(List<PropertyTypeEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<PropertyTypeModel> propertyTypeModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			propertyTypeModels = new ArrayList<>();
			for(PropertyTypeEntity propertyTypeEntity:es) {
				propertyTypeModels.add(entityToModel(propertyTypeEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return propertyTypeModels;
	}

}
