package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.PropertyEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.PropertyModel;

@Component
public class PropertyConverter extends CommonConverter implements BaseConverter<PropertyEntity, PropertyModel> {

	private static final long serialVersionUID = 1937719597880236169L;
	private static final Logger logger = LogManager.getLogger(PropertyConverter.class);

	@Override
	public PropertyEntity modelToEntity(PropertyModel m) {
		
		PropertyEntity propertyEntity = new PropertyEntity();
		propertyEntity = (PropertyEntity) Util.transform(modelMapper, m, propertyEntity);
		propertyEntity.setStatus(Status.INACTIVE.ordinal());
		propertyEntity.setCreatedDate(Util.getCurrentDateTime());
		
		propertyEntity.setPropertyTypeEntity(propertyTypeDAO.find(Long.parseLong(m.getPropertyTypeModel().getPropertyTypeId())));
		propertyEntity.setStayTypeEntity(stayTypeDAO.find(Long.valueOf(m.getStayTypeModel().getStayTypeId())));
		
		
		
		return propertyEntity;
	}

	@Override
	public PropertyModel entityToModel(PropertyEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		PropertyModel propertyModel = null;
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			propertyModel = new PropertyModel();
			propertyModel = (PropertyModel) Util.transform(modelMapper, e, propertyModel);
			propertyModel.setPropertyTypeModel(propertyTypeConverter.entityToModel(e.getPropertyTypeEntity()));
			propertyModel.setStayTypeModel(stayTypeConverter.entityToModel(e.getStayTypeEntity()));
			
			propertyModel.setPropertyVsDocumentModels(propertyVsDocumentConverter.entityListToModelList(e.getPropertyVsDocumentEntities()));
			propertyModel.setPropertyVsDescriptionModels(propertyVsDescriptionConverter.entityListToModelList(e.getPropertyVsDescriptionEntities()));
			propertyModel.setPropertyVsGuestAccessModels(propertyVsGuestAccessConverter.entityListToModelList(e.getPropertyVsGuestAccessEntities()));
			propertyModel.setPropertyVsImageModels(propertyVsImageConverter.entityListToModelList(e.getPropertyVsImageEntities()));
			propertyModel.setPropertyVsNearbyModels(propertyVsNearbyConverter.entityListToModelList(e.getPropertyVsNearbyEntities()));
			propertyModel.setPropertyVsPriceDropModels(propertyVsPriceDropConverter.entityListToModelList(e.getPropertyVsPriceDropEntities()));
			propertyModel.setPropertyVsSpaceRuleModels(propertyVsSpaceRuleConverter.entityListToModelList(e.getPropertyVsSpaceRuleEntities()));
			propertyModel.setPropertyVsSpecialExperienceModels(vsSpecialExperienceConverter.entityListToModelList(e.getPropertyVsSpecialExperienceEntities()));
			
			// Room Details
			propertyModel.setRoomModels(roomConverter.entityListToModelList(e.getRoomEntities()));
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return propertyModel;
	}

	@Override
	public List<PropertyModel> entityListToModelList(List<PropertyEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<PropertyModel> propertyModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			propertyModels = new ArrayList<>();
			for(PropertyEntity propertyEntity:es) {
				propertyModels.add(entityToModel(propertyEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return propertyModels;
	}

}
