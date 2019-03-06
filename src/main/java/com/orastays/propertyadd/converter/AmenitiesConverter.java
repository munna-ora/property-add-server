package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.AmenitiesEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.AmenitiesModel;

@Component
public class AmenitiesConverter extends CommonConverter implements BaseConverter<AmenitiesEntity, AmenitiesModel> {

	private static final long serialVersionUID = 2386241926454947717L;
	private static final Logger logger = LogManager.getLogger(AmenitiesConverter.class);

	@Override
	public AmenitiesEntity modelToEntity(AmenitiesModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AmenitiesModel entityToModel(AmenitiesEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		AmenitiesModel amenitiesModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()){
			amenitiesModel = new AmenitiesModel();
			amenitiesModel = (AmenitiesModel) Util.transform(modelMapper, e, amenitiesModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return amenitiesModel;
	}

	@Override
	public List<AmenitiesModel> entityListToModelList(List<AmenitiesEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<AmenitiesModel> amenitiesModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			amenitiesModels = new ArrayList<>();
			for(AmenitiesEntity amenitiesEntity:es) {
				amenitiesModels.add(entityToModel(amenitiesEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return amenitiesModels;
	}

}
