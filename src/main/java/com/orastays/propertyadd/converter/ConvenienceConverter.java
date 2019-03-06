package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.ConvenienceEntity;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.ConvenienceModel;

@Component
public class ConvenienceConverter extends CommonConverter
		implements BaseConverter<ConvenienceEntity, ConvenienceModel> {

	private static final long serialVersionUID = -1936823828484282012L;
	private static final Logger logger = LogManager.getLogger(ConvenienceConverter.class);

	@Override
	public ConvenienceEntity modelToEntity(ConvenienceModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConvenienceModel entityToModel(ConvenienceEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		ConvenienceModel convenienceModel = new ConvenienceModel();
		convenienceModel = (ConvenienceModel) Util.transform(modelMapper, e, convenienceModel);

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return convenienceModel;
	}

	@Override
	public List<ConvenienceModel> entityListToModelList(List<ConvenienceEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<ConvenienceModel> convenienceModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			convenienceModels = new ArrayList<>();
			for (ConvenienceEntity convenienceEntity : es) {
				convenienceModels.add(entityToModel(convenienceEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return convenienceModels;
	}

}
