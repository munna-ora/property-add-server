package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.GstSlabEntity;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.GstSlabModel;

@Component
public class GstSlabConverter extends CommonConverter implements BaseConverter<GstSlabEntity, GstSlabModel> {

	private static final long serialVersionUID = -5447137916554853440L;
	private static final Logger logger = LogManager.getLogger(GstSlabConverter.class);

	@Override
	public GstSlabEntity modelToEntity(GstSlabModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GstSlabModel entityToModel(GstSlabEntity e) {

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}

		GstSlabModel gstSlabModel = new GstSlabModel();
		gstSlabModel = (GstSlabModel) Util.transform(modelMapper, e, gstSlabModel);

		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}

		return gstSlabModel;
	}

	@Override
	public List<GstSlabModel> entityListToModelList(List<GstSlabEntity> es) {

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}

		List<GstSlabModel> gstSlabModels = null;
		if (!CollectionUtils.isEmpty(es)) {
			gstSlabModels = new ArrayList<>();
			for (GstSlabEntity gstSlabEntity : es) {
				gstSlabModels.add(entityToModel(gstSlabEntity));
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}

		return gstSlabModels;
	}

}
