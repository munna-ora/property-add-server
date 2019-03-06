package com.orastays.propertyadd.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.orastays.propertyadd.entity.RoomVsImageEntity;
import com.orastays.propertyadd.helper.Status;
import com.orastays.propertyadd.helper.Util;
import com.orastays.propertyadd.model.RoomVsImageModel;

@Component
public class RoomVsImageConverter extends CommonConverter
		implements BaseConverter<RoomVsImageEntity, RoomVsImageModel> {

	private static final long serialVersionUID = 6202228879748998556L;
	private static final Logger logger = LogManager.getLogger(RoomVsImageConverter.class);

	@Override
	public RoomVsImageEntity modelToEntity(RoomVsImageModel m) {
		
		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- START");
		}

		RoomVsImageEntity roomVsImageEntity = new RoomVsImageEntity();
		roomVsImageEntity = (RoomVsImageEntity) Util.transform(modelMapper, m, roomVsImageEntity);
		roomVsImageEntity.setStatus(Status.ACTIVE.ordinal());
		roomVsImageEntity.setCreatedDate(Util.getCurrentDateTime());

		if (logger.isInfoEnabled()) {
			logger.info("modelToEntity -- END");
		}

		return roomVsImageEntity;
	}

	@Override
	public RoomVsImageModel entityToModel(RoomVsImageEntity e) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- START");
		}
		
		RoomVsImageModel roomVsImageModel = null;
		if(Objects.nonNull(e) && e.getStatus() == Status.ACTIVE.ordinal()){
			roomVsImageModel = new RoomVsImageModel();
			roomVsImageModel = (RoomVsImageModel) Util.transform(modelMapper, e, roomVsImageModel);
		}
		if (logger.isInfoEnabled()) {
			logger.info("entityToModel -- END");
		}
		
		return roomVsImageModel;
	}

	@Override
	public List<RoomVsImageModel> entityListToModelList(List<RoomVsImageEntity> es) {
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- START");
		}
		
		List<RoomVsImageModel> roomVsImageModels = null;
		if(!CollectionUtils.isEmpty(es)) {
			roomVsImageModels = new ArrayList<>();
			for(RoomVsImageEntity roomVsImageEntity:es) {
				roomVsImageModels.add(entityToModel(roomVsImageEntity));
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("entityListToModelList -- END");
		}
		
		return roomVsImageModels;
	}

}
