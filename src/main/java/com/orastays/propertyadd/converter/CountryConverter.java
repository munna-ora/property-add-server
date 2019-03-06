package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.CountryEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.CountryModel;

@Component
public class CountryConverter extends CommonConverter implements
		BaseConverter<CountryEntity, CountryModel> {

	
	private static final long serialVersionUID = -7185168569141465740L;
	private static final Logger logger = LogManager.getLogger(CountryConverter.class);

	@Override
	public CountryEntity modelToEntity(CountryModel m) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryModel entityToModel(CountryEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		CountryModel countryModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			countryModel = new CountryModel();
			countryModel = (CountryModel) Util.transform(modelMapper, e, countryModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return countryModel;
	}
	

	@Override
	public List<CountryModel> entityListToModelList(List<CountryEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<CountryModel> countryModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			countryModels = new ArrayList<>();
			for (CountryEntity countryEntity : es) {
				countryModels.add(entityToModel(countryEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return countryModels;
	}

}
