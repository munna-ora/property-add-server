package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.SpecialtiesEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.SpecialtiesModel;

@Component
public class SpecialtiesConverter extends CommonConverter
		implements BaseConverter<SpecialtiesEntity, SpecialtiesModel> {

	private static final long serialVersionUID = -6987883354674730631L;
	private static final Logger logger = LogManager.getLogger(SpecialtiesConverter.class);

	@Override
	public SpecialtiesEntity modelToEntity(SpecialtiesModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpecialtiesModel entityToModel(SpecialtiesEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		SpecialtiesModel specialtiesModel = null;
		
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()) {
			specialtiesModel = new SpecialtiesModel();
			specialtiesModel = (SpecialtiesModel) Util.transform(modelMapper, e, specialtiesModel);
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return specialtiesModel;
	}

	@Override
	public List<SpecialtiesModel> entityListToModelList(List<SpecialtiesEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<SpecialtiesModel> specialtiesModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			specialtiesModels = new ArrayList<>();
			for (SpecialtiesEntity specialtiesEntity : es) {
				specialtiesModels.add(entityToModel(specialtiesEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return specialtiesModels;
	}

}
