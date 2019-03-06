package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.PropertyVsSpaceRuleEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.PropertyVsSpaceRuleModel;

@Component
public class PropertyVsSpaceRuleConverter extends CommonConverter
		implements BaseConverter<PropertyVsSpaceRuleEntity, PropertyVsSpaceRuleModel> {

	private static final long serialVersionUID = 4884374267851340797L;
	private static final Logger logger = LogManager.getLogger(PropertyVsSpaceRuleConverter.class);

	@Override
	public PropertyVsSpaceRuleEntity modelToEntity(PropertyVsSpaceRuleModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyVsSpaceRuleEntity propertyVsSpaceRuleEntity = new PropertyVsSpaceRuleEntity();
		propertyVsSpaceRuleEntity = (PropertyVsSpaceRuleEntity) Util.transform(modelMapper, m, propertyVsSpaceRuleEntity);
		propertyVsSpaceRuleEntity.setStatus(Status.ACTIVE.ordinal());
		propertyVsSpaceRuleEntity.setCreatedDate(Util.getCurrentDateTime());
		
		propertyVsSpaceRuleEntity.setSpaceRuleEntity(spaceRuleDAO.find(Long.valueOf(m.getSpaceRuleModel().getSpruleId())));
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyVsSpaceRuleEntity;
	}

	@Override
	public PropertyVsSpaceRuleModel entityToModel(PropertyVsSpaceRuleEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyVsSpaceRuleModel propertyVsSpaceRuleModel = null;
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			propertyVsSpaceRuleModel = new PropertyVsSpaceRuleModel();
			propertyVsSpaceRuleModel = (PropertyVsSpaceRuleModel) Util.transform(modelMapper, e, propertyVsSpaceRuleModel);
			propertyVsSpaceRuleModel.setSpaceRuleModel(spaceRuleConverter.entityToModel(e.getSpaceRuleEntity()));
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyVsSpaceRuleModel;
	}

	@Override
	public List<PropertyVsSpaceRuleModel> entityListToModelList(List<PropertyVsSpaceRuleEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<PropertyVsSpaceRuleModel> propertyVsSpaceRuleModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			propertyVsSpaceRuleModels = new ArrayList<>();
			for(PropertyVsSpaceRuleEntity propertyVsSpaceRuleEntity:es) {
				propertyVsSpaceRuleModels.add(entityToModel(propertyVsSpaceRuleEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return propertyVsSpaceRuleModels;
	}

}
