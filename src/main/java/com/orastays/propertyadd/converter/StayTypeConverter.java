package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.StayTypeEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.StayTypeModel;

@Component
public class StayTypeConverter extends CommonConverter implements BaseConverter<StayTypeEntity, StayTypeModel> {

	private static final long serialVersionUID = 8570388740658367542L;
	private static final Logger logger = LogManager.getLogger(StayTypeConverter.class);

	@Override
	public StayTypeEntity modelToEntity(StayTypeModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StayTypeModel entityToModel(StayTypeEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		StayTypeModel stayTypeModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			stayTypeModel = new StayTypeModel();
			stayTypeModel = (StayTypeModel) Util.transform(modelMapper, e, stayTypeModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return stayTypeModel;
	}

	@Override
	public List<StayTypeModel> entityListToModelList(List<StayTypeEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<StayTypeModel> stayTypeModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			stayTypeModels = new ArrayList<>();
			for (StayTypeEntity stayTypeEntity : es) {
				stayTypeModels.add(entityToModel(stayTypeEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return stayTypeModels;
	}

}
