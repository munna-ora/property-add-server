package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.CityEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.CityModel;

@Component
public class CityConverter extends CommonConverter implements
		BaseConverter<CityEntity, CityModel> {

	private static final long serialVersionUID = 131775959894638735L;
	private static final Logger logger = LogManager.getLogger(CityConverter.class);

	@Override
	public CityEntity modelToEntity(CityModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		CityEntity cityEntity = new CityEntity();
		cityEntity = (CityEntity) Util.transform(modelMapper, m, cityEntity);
		cityEntity.setStatus(Status.ACTIVE.ordinal());
		cityEntity.setCreatedBy(Long.parseLong(String.valueOf(Status.ZERO.ordinal())));
		cityEntity.setCreatedDate(Util.getCurrentDateTime());
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return cityEntity;
	}

	@Override
	public CityModel entityToModel(CityEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		CityModel cityModel = null;
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			cityModel = new CityModel();
			cityModel = (CityModel) Util.transform(modelMapper, e, cityModel);
		}
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return cityModel;
	}

	@Override
	public List<CityModel> entityListToModelList(List<CityEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<CityModel> cityModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			cityModels = new ArrayList<>();
			for(CityEntity cityEntity:es) {
				cityModels.add(entityToModel(cityEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return cityModels;
	}

}
