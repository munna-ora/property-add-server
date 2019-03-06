package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.PropertyVsPriceDropEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.PropertyVsPriceDropModel;

@Component
public class PropertyVsPriceDropConverter extends CommonConverter
		implements BaseConverter<PropertyVsPriceDropEntity, PropertyVsPriceDropModel> {

	private static final long serialVersionUID = -3079477860269369413L;
	private static final Logger logger = LogManager.getLogger(PropertyVsPriceDropConverter.class);

	@Override
	public PropertyVsPriceDropEntity modelToEntity(PropertyVsPriceDropModel m) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyVsPriceDropEntity propertyVsPriceDropEntity = new PropertyVsPriceDropEntity();
		propertyVsPriceDropEntity = (PropertyVsPriceDropEntity) Util.transform(modelMapper, m, propertyVsPriceDropEntity);
		propertyVsPriceDropEntity.setStatus(Status.ACTIVE.ordinal());
		propertyVsPriceDropEntity.setCreatedDate(Util.getCurrentDateTime());
		
		propertyVsPriceDropEntity.setPriceDropEntity(priceDropDAO.find(Long.valueOf(m.getPriceDropModel().getPriceDropId())));
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyVsPriceDropEntity;
	}

	@Override
	public PropertyVsPriceDropModel entityToModel(PropertyVsPriceDropEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyVsPriceDropModel propertyVsPriceDropModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			propertyVsPriceDropModel = new PropertyVsPriceDropModel();
			propertyVsPriceDropModel = (PropertyVsPriceDropModel) Util.transform(modelMapper, e, propertyVsPriceDropModel);
			propertyVsPriceDropModel.setPriceDropModel(priceDropConverter.entityToModel(e.getPriceDropEntity()));
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyVsPriceDropModel;
	}

	@Override
	public List<PropertyVsPriceDropModel> entityListToModelList(List<PropertyVsPriceDropEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<PropertyVsPriceDropModel> propertyVsPriceDropModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			propertyVsPriceDropModels = new ArrayList<>();
			for(PropertyVsPriceDropEntity propertyVsPriceDropEntity:es) {
				propertyVsPriceDropModels.add(entityToModel(propertyVsPriceDropEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return propertyVsPriceDropModels;
	}

}
