package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.SpecialExperienceEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.SpecialExperienceModel;

@Component
public class SpecialExperienceConverter extends CommonConverter
		implements BaseConverter<SpecialExperienceEntity, SpecialExperienceModel> {

	private static final long serialVersionUID = -5794757932589577355L;
	private static final Logger logger = LogManager.getLogger(SpecialExperienceConverter.class);

	@Override
	public SpecialExperienceEntity modelToEntity(SpecialExperienceModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpecialExperienceModel entityToModel(SpecialExperienceEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		SpecialExperienceModel specialExperienceModel = null;
				
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			specialExperienceModel = new SpecialExperienceModel();
			specialExperienceModel = (SpecialExperienceModel) Util.transform(modelMapper, e, specialExperienceModel);
		}
		

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return specialExperienceModel;
	}

	@Override
	public List<SpecialExperienceModel> entityListToModelList(List<SpecialExperienceEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<SpecialExperienceModel> specialExperienceModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			specialExperienceModels = new ArrayList<>();
			for (SpecialExperienceEntity specialExperienceEntity : es) {
				specialExperienceModels.add(entityToModel(specialExperienceEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return specialExperienceModels;
	}

}
